package in.shabhushan.cp_trials.dynamic_programming;

/**
 * Leetcode Solution for
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
  public static int editDistance(String one, String two) {
    int n = one.length();
    int m = two.length();

    int[][] dp = new int[n + 1][m + 1];
    dp[0][0] = 0;

    for (int i = 1; i <= n; i++) {
      dp[i][0] = i;
    }

    for (int j = 1; j <= m; j++) {
      dp[0][j] = j;
    }

    for (int i = 1; i <= n; i++) {
      for (int j = 1; j <= m; j++) {
        if (one.charAt(i - 1) == two.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
        else {
          dp[i][j] = 1 + Math.min(
              dp[i - 1][j-1],
              Math.min(dp[i][j-1], dp[i-1][j])
          );
        }
      }
    }

    return dp[n][m];
  }
}
