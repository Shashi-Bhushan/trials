package in.shabhushan.cp_trials.string;

import java.util.Map;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toMap;

public class HelpTheBookseller {
    // 1st parameter is the stocklist (L in example),
    // 2nd parameter is list of categories (M in example)
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<String, Integer> collect = stream(lstOfArt)
                .map(it -> it.split(" "))
                .collect(toMap(elem -> elem[0].substring(0, 1), e -> parseInt(e[1]), Integer::sum));

        return stream(lstOf1stLetter)
                .map(elem -> String.format("(%s : %d)", elem, collect.getOrDefault(elem, 0)))
                .collect(joining(" - "));
    }
}
