package in.shabhushan.cp_trials.array;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.stream;

public class FindOdd {
    public static int findIt2(int[] a) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int x: a) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (entry.getValue() % 2 != 0)
                return entry.getKey();
        }

        return 0;
    }

    public static int findIt(int[] a) {
        return stream(a).reduce(0, (x ,y) -> x ^ y);
    }
}
