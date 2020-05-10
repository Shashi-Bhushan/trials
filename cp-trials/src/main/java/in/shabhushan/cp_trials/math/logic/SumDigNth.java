package in.shabhushan.cp_trials.math.logic;

import java.util.Arrays;

public class SumDigNth {

    /**
     * Take sum of pattern,
     * instead of doing a for loop and adding them one by one,
     * add to initial value at once.
     * <p>
     * Then, get sum of individual digits
     */
    public static long sumDigNthTerm(long initval, long[] patternl, int nthterm) {
        long sum = Arrays.stream(patternl).sum();
        int len = patternl.length;

        // convert to 0 based index
        nthterm = nthterm - 1;

        // add to initial value
        long val = initval + (sum * (nthterm / len));

        // Find out how many more in pattern array needs to be added now
        long[] newLongs = Arrays.copyOf(patternl, nthterm % len);

        // add to value
        val += Arrays.stream(newLongs).sum();

        int digitSum = 0;

        while (val > 0) {
            digitSum += val % 10;
            val /= 10;
        }

        return digitSum;
    }
}
