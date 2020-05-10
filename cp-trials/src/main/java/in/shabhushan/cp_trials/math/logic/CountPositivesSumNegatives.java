package in.shabhushan.cp_trials.math.logic;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.partitioningBy;

public class CountPositivesSumNegatives {
    public static int[] countPositivesSumNegatives(int[] input) {
        if (input.length == 0) return new int[]{};

        Map<Boolean, List<Integer>> map =
                Arrays.stream(input).boxed().filter(elem -> elem != 0).collect(partitioningBy(elem -> elem < 0));

        return new int[]{
                map.get(false).size(),
                map.get(true).stream().mapToInt(Integer::intValue).sum(),
        };
    }
}
