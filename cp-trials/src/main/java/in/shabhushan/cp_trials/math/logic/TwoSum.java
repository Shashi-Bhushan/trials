package in.shabhushan.cp_trials.math.logic;

import java.util.HashMap;

public class TwoSum {
    public static int[] twoSum(int[] numbers, int target) {
        var numToIndex = new HashMap<Integer, Integer>();

        for (int index = 0; index < numbers.length; index++) {
            numToIndex.put(numbers[index], index);
        }

        for (int index = 0; index < numbers.length; index++) {
            int secondNum = target - numbers[index];

            if (numToIndex.containsKey(secondNum)) {
                return new int[]{
                        index,
                        numToIndex.get(secondNum)
                };
            }
        }

        return new int[]{};
    }
}
