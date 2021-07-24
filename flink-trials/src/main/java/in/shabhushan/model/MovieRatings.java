package in.shabhushan.model;


import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Singular;

import java.util.Set;


@Data
@RequiredArgsConstructor
public class MovieRatings {
    @NonNull
    private String movie;

    @NonNull
    private Double rating;

    @NonNull
    @Singular
    private Set<String> genres;
}
