package in.shabhushan.algo_trials.dynamic_programming.chapter9;

/**
 * Leetcode Solution for
 * https://leetcode.com/problems/edit-distance/
 */
public class EditDistance {
  public static int editDistance(String one, String two) {
    if (one == null || one.isEmpty()) return two.length();
    else if (two == null || two.isEmpty()) return one.length();
    else if (one.charAt(0) == two.charAt(0)) return editDistance(one.substring(1), two.substring(1));
    else {
      int delete = editDistance(one.substring(1), two); // delete first char from one
      int update = editDistance(one.substring(1), two.substring(1)); // consider one of these have been updated to other
      // insert first char from second to one, Since here size of one has increased by one, we won't move pointer forward
      int insert = editDistance(one, two.substring(1));

      return Math.min(delete, Math.min(update, insert)) + 1;
    }
  }

  public static int editDistanceDP(String one, String two) {
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
