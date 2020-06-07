package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.dropFirstChar;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.StringInterleaving.firstChar;

public class LongestCommonSubsequence {
  public static int longestCommonSubsequenceLength(String one, String two) {
    if (one.isEmpty() || two.isEmpty()) return 0;

    if (firstChar(one) == firstChar(two)) {
      return 1 + longestCommonSubsequenceLength(dropFirstChar(one), dropFirstChar(two));
    } else {
      return Math.max(
          longestCommonSubsequenceLength(dropFirstChar(one), two),
          longestCommonSubsequenceLength(one, dropFirstChar(two))
      );
    }
  }

  public static int longestCommonSubsequenceLengthDP(String one, String two) {
    if (one.isEmpty() || two.isEmpty()) return 0;

    int[][] dp = new int[one.length() + 1][two.length() + 1];

    for (int i = 1; i <= one.length(); i++) {
      for (int j = 1; j <= two.length(); j++) {
        if (one.charAt(i - 1) == two.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1] + 1;
        else
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
      }
    }

    return dp[one.length()][two.length()];
  }
}
