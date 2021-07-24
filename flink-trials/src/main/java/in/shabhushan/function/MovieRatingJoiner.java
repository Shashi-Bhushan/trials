package in.shabhushan.function;

import in.shabhushan.model.Movie;
import in.shabhushan.model.MovieRatings;
import in.shabhushan.model.Rating;
import org.apache.flink.api.common.functions.JoinFunction;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MovieRatingJoiner implements JoinFunction<Movie, Rating, MovieRatings> {

    @Override
    public MovieRatings join(Movie movie, Rating rating) {
        String movieName = movie.getName();
        Set<String> genres = new HashSet<>(Arrays.asList(movie.getGenres().split("\\|")));
        Double movieRating = rating.getRating();

        return new MovieRatings(movieName, movieRating, genres);
    }
}
