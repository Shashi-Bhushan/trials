package in.shabhushan.cp_trials.math.logic;

import java.util.ArrayList;
import java.util.List;

class BuddyPair {
    public static String buddy(long start, long limit) {
        for (long index = start; index <= limit; index++) {
            long sum = findSum(index);

            if (index < sum) {
                long counterSum = findSum(sum);

                if (counterSum == index) {
                    return String.format("(%d %d)", index, sum);
                }
            }
        }

        return "Nothing";
    }

    public static long findSum(long n) {
        long index = 2L;
        List<Long> list = new ArrayList<>();

        while (index * index < n) {
            if (n % index == 0) {
                list.add(index);
                list.add(n / index);
            }

            index++;
        }

        return list.stream().reduce(0L, Long::sum);
    }
}
