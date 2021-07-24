package in.shabhushan.model;

import org.apache.flink.api.java.tuple.Tuple3;

public class Movie extends Tuple3<Integer, String, String> {
    public Integer getMovieId() {
        return this.f0;
    }

    public String getName() {
        return this.f1;
    }

    public String getGenres() {
        return this.f2;
    }
}
