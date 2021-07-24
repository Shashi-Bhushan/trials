package in.shabhushan.model;


import org.apache.flink.api.java.tuple.Tuple4;

public class Rating extends Tuple4<Integer, Integer, Double, Long> {

    public Integer getUserId() {
        return this.f0;
    }

    public Integer getMovieId() {
        return this.f1;
    }

    public Double getRating() {
        return this.f2;
    }

    public Long getTimestamp() {
        return this.f3;
    }
}
