package in.shabhushan.cp_trials.math.fundamental;

import java.util.Arrays;

public class NextBigger {
  public static long nextBiggerNumber(long n) {
    int[] nums = String.valueOf(n).chars().map(num -> num - '0').toArray();

    for (int index = nums.length - 1; index > 0; index--) {
      // find the number from end, where increasing trend ends
      if (nums[index - 1] < nums[index]) {
        // found the index which needs to be shifted (index - 1)

        // Find the first number from right, which is greater than index - 1
        int max = Integer.MIN_VALUE; // consider index as max initially
        for (int j = nums.length - 1; j >= index; j--) {
          if (nums[index - 1] < nums[j]) {
            max = j;
            break;
          }
        }

        // replace max and index - 1
        int temp = nums[index - 1];
        nums[index - 1] = nums[max];
        nums[max] = temp;

        // Sort Ascending from index to end
        Arrays.sort(nums, index, nums.length);
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
