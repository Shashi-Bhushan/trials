package in.shabhushan.algo_trials.dynamic_programming.chapter8;

/**
 * Consider a game where each player can score 3, 5, or 10 points in each score.
 * Calculate the total number of unique ways of scoring a score of N.
 */
public class WaysToScore {
  public static int getWaysToScore(int n) {
    if (n < 0) return 0;
    else if (n == 0) return 1;
    else return getWaysToScore(n - 3) + getWaysToScore(n - 5) + getWaysToScore(n - 10);
  }

  public static int getWaysToScoreIterative(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      if (i - 3 >= 0) dp[i] += dp[i - 3];
      if (i - 5 >= 0) dp[i] += dp[i - 5];
      if (i - 10 >= 0) dp[i] += dp[i - 10];
    }

    return dp[n];
  }
}
