package in.shabhushan.cp_trials;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class DisemvowelTrolls {
    private static List<Character> vowels = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

    public static String disemvowel(String str) {
        return str.chars()
                .mapToObj(i -> (char)i)
                .filter(it -> !vowels.contains(it))
                .map(String::valueOf)
                .collect(Collectors.joining());
    }
}
