package in.shabhushan;

import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.common.functions.JoinFunction;
import org.apache.flink.api.common.functions.MapPartitionFunction;
import org.apache.flink.api.common.functions.Partitioner;
import org.apache.flink.api.common.operators.Order;
import org.apache.flink.api.java.DataSet;
import org.apache.flink.api.java.ExecutionEnvironment;
import org.apache.flink.api.java.operators.DataSource;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.api.java.tuple.Tuple3;
import org.apache.flink.util.Collector;

import java.util.Iterator;

public class Top10Movies {
    private static final String DIR = "/media/shashi/5c0257d4-ee3d-4ed3-8072-ea5aca6e7f1d/dataset/ml-latest-small/";
    private static final String MOVIES_FILE = DIR + "movies.csv";
    private static final String RATINGS_FILE = DIR + "ratings.csv";

    public static void main(String[] args) throws Exception {
        ExecutionEnvironment env = ExecutionEnvironment.getExecutionEnvironment();

        DataSet<Tuple2<Long, Double>> sorted = env.readCsvFile(RATINGS_FILE)
                .ignoreFirstLine()
                .includeFields(false, true, true, false)
                .parseQuotedStrings('"')
                .ignoreInvalidLines()
                .types(Long.class, Double.class)
                .groupBy(0)
                .reduceGroup(new GroupReduceFunction<Tuple2<Long, Double>, Tuple2<Long, Double>>() {
                    @Override
                    public void reduce(Iterable<Tuple2<Long, Double>> iterable, Collector<Tuple2<Long, Double>> collector) throws Exception {
                        Long movieId = null;
                        double total = 0;
                        int count = 0;

                        for (Tuple2<Long, Double> value : iterable) {
                            movieId = value.f0;
                            total += value.f1;
                            count++;
                        }

                        // if less than 50 users have given a rating, ignore it
                        if (count > 50) {
                            collector.collect(new Tuple2<>(movieId, total/count));
                        }
                    }
                })
                // partition based on movie rating
                .partitionCustom(new Partitioner<Double>() {
                    @Override
                    public int partition(Double key, int partitionNumber) {
                        // partition will be from 0-4 then
                        // all movies have rating from 1 to 5
                        return key.intValue();
                    }
                }, 1)
                .setParallelism(5)
                .sortPartition(1, Order.DESCENDING)
                // collect top 10 from each partition
                .mapPartition(new MapPartitionFunction<Tuple2<Long, Double>, Tuple2<Long, Double>>() {
                    @Override
                    public void mapPartition(Iterable<Tuple2<Long, Double>> iterable, Collector<Tuple2<Long, Double>> collector) throws Exception {
                        Iterator<Tuple2<Long, Double>> iterator = iterable.iterator();

                        for (int i = 0; i < 10 && iterator.hasNext(); i++) {
                            collector.collect(iterator.next());
                        }
                    }
                })
                // Sort Remaining data on a Single Partition
                .sortPartition(1, Order.DESCENDING)
                .setParallelism(1)
                // collect top 10 movies
                .mapPartition(new MapPartitionFunction<Tuple2<Long, Double>, Tuple2<Long, Double>>() {
                    @Override
                    public void mapPartition(Iterable<Tuple2<Long, Double>> iterable, Collector<Tuple2<Long, Double>> collector) throws Exception {
                        Iterator<Tuple2<Long, Double>> iterator = iterable.iterator();

                        for (int i = 0; i < 10 && iterator.hasNext(); i++) {
                            collector.collect(iterator.next());
                        }
                    }
                });

        DataSource<Tuple2<Long, String>> movies = env.readCsvFile(MOVIES_FILE)
                .ignoreFirstLine()
                .includeFields(true, true, false)
                .parseQuotedStrings('"')
                .ignoreInvalidLines()
                .types(Long.class, String.class);

        movies.join(sorted)
                .where(0)
                .equalTo(0)
                .with(new JoinFunction<Tuple2<Long, String>, Tuple2<Long, Double>, Tuple3<Long, String, Double>>() {
                    @Override
                    public Tuple3<Long, String, Double> join(Tuple2<Long, String> movie, Tuple2<Long, Double> rating) throws Exception {
                        return new Tuple3<>(movie.f0, movie.f1, rating.f1);
                    }
                })
                .print();

    }
}
