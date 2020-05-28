package in.shabhushan.cp_trials.dynamic_programming;

public class TotalNumberOfWays {
  public static int totalWays(int n) {
    int[][] dp = new int[n][n];
    dp[0][0] = 1;

    for (int i = 1; i < n; i++) {
      dp[0][i] = 1;
      dp[i][0] = 1;
    }

    for (int i = 1; i < n; i++) {
      for (int j = 1; j < n; j++) {
        dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
      }
    }

    return dp[n - 1][n - 1];
  }
}
