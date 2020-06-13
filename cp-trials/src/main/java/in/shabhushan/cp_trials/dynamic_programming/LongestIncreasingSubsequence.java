package in.shabhushan.cp_trials.dynamic_programming;

public class LongestIncreasingSubsequence {
  public static int lengthOfLIS(int[] nums) {
    int max = 0;

    for (int i = 0; i < nums.length; i++) {
      max = Math.max(max, helper(nums, i, 1));
    }

    return max;
  }

  private static int helper(int[] nums, int index, int sum) {
    if (index + 1 == nums.length) return sum;

    int max = sum;

    for (int i = index + 1; i < nums.length; i++) {
      if (nums[index] < nums[i]) {
        max = Math.max(max, helper(nums, i, sum + 1));
      }
    }

    return max;
  }

  /**
   * Check this for reference
   * https://leetcode.com/problems/longest-increasing-subsequence/discuss/671359/My-Java-DP-Solution-with-Pictorial-Explanation
   */
  public static int lengthOfLISDP(int[] nums) {
    if (nums.length == 0) return 0;

    int[] dp = new int[nums.length];
    dp[0] = 1;

    int ans = 1;

    // between 0 and i, whichever nums[j] is greater than nums[i], get max of dp[j] for those.
    for (int i = 1; i < nums.length; i++) {
      int max = 1;
      for (int j = i - 1; j >=0; j--) {
        if (nums[i] > nums[j]) {
          max = Math.max(max, dp[j] + 1);
        }
      }

      dp[i] = max;
      ans = Math.max(ans, max);
    }


    return ans;
  }
}
