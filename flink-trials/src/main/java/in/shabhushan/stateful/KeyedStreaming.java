package in.shabhushan.stateful;

import org.apache.flink.api.common.functions.MapFunction;
import org.apache.flink.api.common.serialization.SimpleStringEncoder;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.core.fs.Path;
import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.datastream.KeyedStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;
import org.apache.flink.streaming.api.functions.sink.filesystem.StreamingFileSink;

/**
 * Download data from
 * https://www.kaggle.com/tomasmantero/top-tech-companies-stock-price?select=Technology+Sector+List.csv
 */
public class KeyedStreaming {
    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();

        DataStream<String> sourceStream = env.readTextFile("data/input/Technology Sector List.csv");

        DataStream<Tuple2<String, Double>> closePrice = sourceStream.filter(line -> !line.contains("Symbol,Name,Price,Change,% Change,Volume,Avg Vol,Market Cap (Billions),PE Ratio"))
                .map(new MapFunction<String, Tuple2<String, Double>>() {
                    @Override
                    public Tuple2<String, Double> map(String s) throws Exception {
                        String[] data = s.split(",");
                        return Tuple2.of(data[1], Double.parseDouble(data[2]));
                    }
                });

        KeyedStream<Tuple2<String, Double>, Integer> keyedStream = closePrice.keyBy(value -> (value.f1.intValue() % 10));

        //StreamingFileSink<Tuple2<String, Double>> sink = StreamingFileSink.forRowFormat(new Path("src/main/resources/sink"), new SimpleStringEncoder<Tuple2<String, Double>>("UTF-8")).build();
        //keyedStream.addSink(sink);
        keyedStream.print();

        env.execute();
    }
}
