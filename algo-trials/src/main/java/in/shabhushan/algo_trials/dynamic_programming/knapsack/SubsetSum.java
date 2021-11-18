package in.shabhushan.algo_trials.dynamic_programming.knapsack;

public class SubsetSum {
  private SubsetSum() {}

  public static boolean subsetSum(int[] arr, int sum) {
    boolean[][] dp = new boolean[arr.length + 1][sum + 1];

    for (int i = 0; i <= arr.length; i++) {
      for (int j = 0; j <= sum; j++) {
        // first two are initialize conditions
        if (j == 0) {
          // first column true
          dp[i][j] = true;
        } else if (i == 0) {
          // first row false
          dp[i][j] = false;
        } else {
          if (arr[i - 1] <= j) {
            // arr[value] is lower than j
            // either take it or not
            dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
          } else {
            // arr[value] is higher than j
            // can't select this arr[value], choose only the previous dp value
            dp[i][j] = dp[i - 1][j];
          }
        }
      }
    }

    return dp[arr.length][sum];
  }
}
