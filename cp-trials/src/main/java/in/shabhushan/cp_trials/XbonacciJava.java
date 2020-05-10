package in.shabhushan.cp_trials;

import java.util.Arrays;
import java.util.stream.Stream;

public class XbonacciJava {
    public static double[] tribonacci(double[] signature, int n) {
        if (n > 3 && signature.length >= 3) {
            return Stream
                    .iterate(signature, tuple -> new double[]{tuple[1], tuple[2], tuple[0] + tuple[1] + tuple[2]})
                    .mapToDouble(tuple -> tuple[0])
                    .limit(n)
                    .toArray();
        } else {
            return Arrays.stream(signature).limit(n).toArray();
        }
    }

    public static double[] fibonacci(double[] signature, int n) {
        if (n > 2 && signature.length >= 2) {
            return Stream
                    .iterate(signature, tuple -> new double[]{tuple[1], tuple[0] + tuple[1]})
                    .mapToDouble(tuple -> tuple[0])
                    .limit(n)
                    .toArray();
        } else {
            return Arrays.stream(signature).limit(n).toArray();
        }
    }
}
