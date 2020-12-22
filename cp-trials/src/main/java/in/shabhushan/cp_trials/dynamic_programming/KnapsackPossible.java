package in.shabhushan.cp_trials.dynamic_programming;

public class KnapsackPossible {
  /**
   * Given an array of weights, determine all the sums that are possible with the weights
   */
  public static boolean[] isPossible(int[] weight) {
    // get sum of weights
    int sum = 0;
    for (int a : weight)
      sum += a;

    boolean[] dp = new boolean[sum + 1];
    dp[0] = true;

    for (int i = 1; i <= sum; i++) {
      dp[i] = helper(weight, weight.length - 1, i);
    }

    return dp;
  }

  private static boolean helper(int[] weight, int lastIndex, int target) {
    if (target == 0) return true;
    else if (lastIndex == 0) return weight[lastIndex] == target;

    if (target - weight[lastIndex] >= 0) {
      return helper(weight, lastIndex - 1, target - weight[lastIndex]) ||
          helper(weight, lastIndex - 1, target)
          ;
    } else {
      return helper(weight, lastIndex - 1, target);
    }
  }

  public static boolean[] isPossibleDP(int[] weight) {
    int sum = 0;
    for (int a : weight)
      sum += a;

    int n = weight.length;
    boolean[][] dp = new boolean[sum + 1][n + 1];

    for (int i = 0; i <= n; i++)
      dp[0][i] = true;

    for (int target = 1; target <= sum; target++) {
      for (int j = 1; j <= n; j++) {
        if (target - weight[j - 1] >= 0) {
          dp[target][j] = dp[target][j] || dp[target - weight[j - 1]][j - 1] || dp[target][j - 1];
        } else {
          dp[target][j] = dp[target][j] || dp[target][j - 1];
        }
      }
    }

    // select last column
    boolean[] ans = new boolean[sum + 1];
    for (int i = 0; i <= sum; i++)
      ans[i] = dp[i][n];

    return ans;
  }

  public static boolean[] isPossible2(int[] weight) {
    int sum = 0;

    for (int w: weight) {
      sum += w;
    }

    boolean[] result = new boolean[sum + 1];

    helper(sum, weight, result, 0);

    return result;
  }

  private static void helper(int sum, int[] weight, boolean[] result, int index) {
    if (index <= weight.length) {
      result[sum] = true;

      for (int i = 0; i < weight.length; i++) {
        if (weight[i] != 0 && sum - weight[i] >= 0 && result[sum - weight[i]] == false) {
          int temp = weight[i];

          weight[i] = 0;

          helper(sum - temp, weight, result, index + 1);

          weight[i] = temp;
        }
      }
    }
  }

  private static boolean helper2(int[] weight, int firstIndex, int target) {
    if (target == 0) return true;
    if (firstIndex == weight.length - 1) return weight[firstIndex] == target;

    if (weight[firstIndex] <= target) {
      return helper2(weight, firstIndex + 1, target - weight[firstIndex]) ||
          helper2(weight, firstIndex + 1, target);
    } else {
      return helper2(weight, firstIndex + 1, target);
    }
  }

  public static boolean[] isPossibleDP2(int[] weight) {
    int sum = 0;

    for (int w: weight)
      sum += w;

    int n = weight.length;
    boolean[][] dp = new boolean[sum + 1][n + 1];

    for (int i = 0; i <= n; i++)
      dp[0][i] = true;

    for (int target = 1; target <= sum; target++) {
      for (int j = 1; j <= n; j++) {
        if (weight[j - 1] <= target)
          dp[target][j] = dp[target][j] || dp[target - weight[j - 1]][j - 1] || dp[target][j - 1];
        else
          dp[target][j] = dp[target][j] || dp[target][j - 1];
      }
    }

    // select last column
    boolean[] ans = new boolean[sum + 1];
    for (int i = 0; i <= sum; i++)
      ans[i] = dp[i][weight.length];

    return ans;
  }
}
