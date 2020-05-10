package in.shabhushan.cp_trials;

import java.util.function.Function;
import java.util.stream.Collectors;

public class DuplicateCounterJava {
    public static int duplicateCounter(String text) {
        return (int) text.chars()
                .mapToObj(i -> (char) i)
                .map(String::valueOf)
                .map(String::toLowerCase)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                ).entrySet().stream().filter(it -> it.getValue() > 1)
                .count();
    }

    public static void main(String[] args) {
        System.out.println(duplicateCounter("abAghb"));
    }
}
