package in.shabhushan.cp_trials.math.logic;

import java.util.stream.IntStream;

public class ExtraPerfectNumber {
    public static int[] extraPerfect(int number)
    {
        return IntStream.range(1, number + 1).filter(elem -> {
            String binary = binary(elem);
            return binary.charAt(0) == '1' && binary.charAt(binary.length() - 1) == '1';
        }).toArray();
    }

    public static String binary(int n) {
        if (n == 1) return n + ""; else return binary(n/2) + n % 2;
    }
}
