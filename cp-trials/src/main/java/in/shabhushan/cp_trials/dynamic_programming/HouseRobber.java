package in.shabhushan.cp_trials.dynamic_programming;

import java.util.Arrays;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/house-robber/submissions/
 */
class HouseRobber {
  public static int rob(int[] nums) {
    if (nums.length == 0) return 0;
    else if (nums.length == 1) return nums[0];
    else if (nums.length == 2) return Math.max(nums[0], nums[1]);

    int[] dp = new int[nums.length + 1];
    dp[0] = 0;
    dp[1] = nums[0];
    dp[2] = Math.max(nums[0], nums[1]);

    for (int i = 3; i <= nums.length; i++) {
      dp[i] = Math.max(
        nums[i - 1] + dp[i - 2],
        dp[i - 1]
      );
    }

    return dp[nums.length];
  }

  public static int rob2(int[] nums) {
    if (nums.length == 0) return 0;
    else if (nums.length == 1) return nums[0];
    else if (nums.length == 2) return Math.max(nums[0], nums[1]);

    return Math.max(
      nums[0] + rob(Arrays.copyOfRange(nums, 2, nums.length)),
      nums[1] + rob(Arrays.copyOfRange(nums, 3, nums.length))
    );
  }
}
