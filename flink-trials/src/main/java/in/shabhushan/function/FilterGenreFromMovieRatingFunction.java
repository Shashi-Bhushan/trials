package in.shabhushan.function;

import in.shabhushan.model.MovieRating;
import in.shabhushan.model.MovieRatings;
import org.apache.flink.api.common.functions.RichFlatMapFunction;
import org.apache.flink.util.Collector;

public class FilterGenreFromMovieRatingFunction extends RichFlatMapFunction<MovieRatings, MovieRating> {

    @Override
    public void flatMap(MovieRatings movieRatings, Collector<MovieRating> collector) throws Exception {
        for (String genre : movieRatings.getGenres()) {
            collector.collect(new MovieRating(movieRatings.getMovie(), movieRatings.getRating(), genre));
        }
    }
}
