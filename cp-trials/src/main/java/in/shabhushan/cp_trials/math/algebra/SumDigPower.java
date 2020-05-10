package in.shabhushan.cp_trials.math.algebra;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

import static java.util.stream.Collectors.toList;

class SumDigPower {

    public static List<Long> sumDigPow(long a, long b) {
        return LongStream.rangeClosed(a, b).boxed().filter(SumDigPower::isNumEquals).collect(toList());
    }

    public static boolean isNumEquals(long num) {
        long tempNum = num;
        var list = new ArrayList<Long>();

        while (tempNum != 0) {
            list.add(tempNum % 10);
            tempNum /= 10;
        }

        int power = list.size();
        long calculatedSum = 0;

        for (int index = 0; index < list.size(); index++) {
            int finalIndex = index;
            calculatedSum += LongStream.range(0, power).map(elem -> list.get(finalIndex)).reduce((acc, element) -> acc * element).getAsLong();

            power--;
        }

        return num == calculatedSum;
    }
}
