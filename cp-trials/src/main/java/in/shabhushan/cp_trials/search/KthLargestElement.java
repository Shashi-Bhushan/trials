package in.shabhushan.cp_trials.search;

import java.util.Arrays;

public class KthLargestElement {
  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);

    return nums[nums.length - k];
  }
}
