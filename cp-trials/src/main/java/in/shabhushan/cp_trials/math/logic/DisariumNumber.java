package in.shabhushan.cp_trials.math.logic;

import java.util.stream.IntStream;

import static java.lang.Math.pow;

public class DisariumNumber {
    public static String disariumNumber(int number)
    {
        IntStream intStream = String.valueOf(number).chars().map(elem -> elem - '0');
        int[] index = {1};
        return (int)intStream
                .mapToDouble(elem -> pow(elem, index[0]++)).sum() == number ? "Disarium !!" : "Not !!";
    }
}
