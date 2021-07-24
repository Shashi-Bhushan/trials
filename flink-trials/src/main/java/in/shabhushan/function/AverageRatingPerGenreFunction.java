package in.shabhushan.function;

import in.shabhushan.model.MovieRating;
import org.apache.flink.api.common.functions.GroupReduceFunction;
import org.apache.flink.api.java.tuple.Tuple2;
import org.apache.flink.util.Collector;

public class AverageRatingPerGenreFunction implements GroupReduceFunction<MovieRating, Tuple2<String, Double>> {
    @Override
    public void reduce(Iterable<MovieRating> iterable, Collector<Tuple2<String, Double>> collector) throws Exception {
        double score = 0.0d;
        int count = 0;

        String genre = "";

        for (MovieRating movieRating : iterable) {
            genre = movieRating.getGenre();

            score += movieRating.getRating();
            count++;
        }

        collector.collect(new Tuple2<>(genre, score / count));
    }
}
