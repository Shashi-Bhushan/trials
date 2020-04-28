package in.shabhushan.algo_trials.trials;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class MissingElements {
  /**
   * Check the answer for detail
   * https://stackoverflow.com/a/5752304/2449146
   */
  public static List<Integer> missingElements(int[] nums, int k) {
    int[] numbers = new int[nums.length + k];

    for (int i = 0; i < numbers.length; i++) {
      if (i < nums.length) {
        numbers[i] = nums[i];
      } else {
        numbers[i] = nums[0];
      }
    }

    // Sort numbers in their range only upto n, not n + k
    for (int i = 0; i < nums.length; i++) {
      while (numbers[numbers[i]] != numbers[i]) {
        int temp = numbers[numbers[i]];
        numbers[numbers[i]] = numbers[i];
        numbers[i] = temp;
      }
    }

    // Return indexes
    return IntStream.range(0, numbers.length).filter(i -> numbers[i] != i).boxed().collect(Collectors.toList());
  }
}
