package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import java.util.List;

/**
 * Consider a game where each player can score 3, 5, or 10 points in each score.
 * Calculate the total number of ways of scoring a score of N.
 * Note 3, 5 is considered different than 5, 3 here.
 */
public class WaysToScore {
  public static int getWaysToScore(int n) {
    if (n < 0) return 0;
    else if (n == 0) return 1;
    else return getWaysToScore(n - 3) + getWaysToScore(n - 5) + getWaysToScore(n - 10);
  }

  /**
   * Note how negative condition n < 0 is handled in dp version of solution
   */
  public static int getWaysToScoreDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    for (int i = 1; i <= n; i++) {
      if (i - 3 >= 0) dp[i] += dp[i - 3];
      if (i - 5 >= 0) dp[i] += dp[i - 5];
      if (i - 10 >= 0) dp[i] += dp[i - 10];
    }

    return dp[n];
  }

  /**
   * You can find the distinct combinations by enforcing a constraint that
   * the elements in each combination must be monotonically increasing
   * https://stackoverflow.com/questions/37850116/dynamic-programming-number-of-distinct-combinations-to-reach-a-given-score
   */
  public static int getDistinctWaysToScore(int n, int min) {
    if (n < 0) return 0;
    else if (n == 0) return 1;
    else {
      int ways = 0;

      if (min <= 3) ways += getDistinctWaysToScore(n - 3, 3);
      if (min <= 5) ways += getDistinctWaysToScore(n - 5, 5);
      if (min <= 10) ways += getDistinctWaysToScore(n - 10, 10);

      return ways;
    }
  }

  /**
   * Note how monotonically increasing score has been ensured via a for loop iteration here
   */
  public static int getDistinctWaysToScoreDP(int n) {
    int[] dp = new int[n + 1];
    dp[0] = 1;

    // for each score, count only ones
    for (int score : List.of(3, 5, 10)) {
      for (int i = 1; i <= n; i++) {
        if (i - score >= 0) dp[i] += dp[i - score];
      }
    }

    return dp[n];
  }
}
