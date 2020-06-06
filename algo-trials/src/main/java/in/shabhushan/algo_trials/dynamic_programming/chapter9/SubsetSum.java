package in.shabhushan.algo_trials.dynamic_programming.chapter9;

/**
 * Given an array of non negative integers and a positive integer X, determine if there exists a subset of elements in the
 * array with sum equal to X.
 */
public class SubsetSum {
  public static boolean subsetSum(int[] array, int targetSum) {
    return helper(array, 0, 0, targetSum);
  }

  private static boolean helper(int[] array, int index, int currentSum, int targetSum) {
    if (currentSum == targetSum) return true;
    else if (index == array.length) return false;

    for (int i = index; i < array.length; i++) {
      if (array[i] <= targetSum) {
        if (helper(array, i + 1, currentSum + array[i], targetSum))
          return true;
      }
    }

    return false;
  }

  public static boolean subsetSumDP(int[] array, int targetSum) {
    boolean[][] dp = new boolean[array.length + 1][targetSum + 1];

    dp[0][0] = true;
    for (int i = 1; i <= targetSum; i++) {
      dp[0][i] = false;
    }

    for (int i = 1; i <= array.length; i++) {
      dp[i][0] = true;
    }

    for (int i = 1; i <= array.length; i++) {
      for (int j = 1; j <= targetSum; j++) {
        int value = array[i - 1];

        // if j is less than value, copy from previous row
        if (j < value) dp[i][j] = dp[i - 1][j];
        // if previous row value is true, set this to true as well.
        else if (dp[i - 1][j]) dp[i][j] = true;
        else dp[i][j] = dp[i - 1][j - value];
      }
    }

    return dp[array.length][targetSum];
  }
}
