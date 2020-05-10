package in.shabhushan.cp_trials.math.fundamental;

import java.util.Arrays;
import java.util.Collections;

public class NextSmaller {
  public static long nextSmaller(long n) {
    Integer[] nums = String.valueOf(n).chars().map(num -> num - '0').boxed().toArray(Integer[]::new);

    for (int index = nums.length - 1; index > 0; index--) {
      // find the number from end, where decreasing trend ends
      if (nums[index - 1] > nums[index]) {
        // found the index (at index - 1) which needs to be shifted

        // Now find max number between (index and nums.length), which is just smaller than nums[index - 1]
        int max = index; // consider index as max initially
        for (int j = index; j < nums.length; j++) {
          if (nums[max] < nums[j] && nums[j] < nums[index -1])
            max = j;
        }

        // swap max and index - 1
        int temp = nums[index - 1];
        nums[index - 1] = nums[max];
        nums[max] = temp;

        // Sort Descending from index to end
        Arrays.sort(nums, index, nums.length, Collections.reverseOrder());
        // if first number is 0, it means actual number length has reduced
        if (nums[0] == 0)
          return -1;
        else
          // convert to number
          return Arrays.stream(nums).mapToLong(num -> num).reduce(0L, (a, b) -> a * 10 + b);
      }
    }

    return -1;
  }
}
