package in.shabhushan.cp_trials.math.logic;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class LengthOfMissing {
    public static int getLengthOfMissingArray(Object[][] arrayOfArrays) {
        if (arrayOfArrays.length == 0) return 0;

        List<Integer> collect = Arrays.stream(arrayOfArrays)
                .mapToInt(array -> array.length)
                .sorted()
                .boxed().collect(Collectors.toList());

        int actualArraySum = collect.stream().mapToInt(obj -> obj).sum();

        Integer firstArrayLength = collect.get(0);
        Integer lastArrayLength = collect.get(collect.size() - 1);

        int idealSum = (int) (((1.0 + collect.size()) / 2) * (firstArrayLength + lastArrayLength));

        return idealSum - actualArraySum;
    }
}
