package in.shabhushan.cp_trials.math.logic;

import java.util.stream.IntStream;

public class StrongNumber {
    private static String STRONG = "STRONG!!!!";
    private static String NOT_STRONG = "Not Strong !!";

    public static String isStrongNumber(int num) {
        return String.valueOf(num).chars().map(elem -> factorial(elem - '0')).sum() == num ? STRONG : NOT_STRONG;
    }

    public static int factorial(Integer n) {
        if (n == 0) return 1;

        return IntStream.range(1, n + 1).reduce((num, acc) -> acc * num).getAsInt();
    }
}
