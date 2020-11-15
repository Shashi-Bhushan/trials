package in.shabhushan.algo_trials.clrs.chapter15;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class LongestCommonSubsequence {
  public static String getLongestCommonSubsequence(String first, String second) {
    int m = first.length();
    int n = second.length();

    int[][] dp = new int[m + 1][n + 1];

    for (int i = 1; i <= m; i++) {
      for (int j = 1; j <= n; j++) {
        if (first.charAt(i - 1) == second.charAt(j - 1)) {
          dp[i][j] = dp[i - 1][j - 1] + 1;
        } else {
          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
        }
      }
    }

    return getLCS(first, second, dp);
  }

  private static String getLCS(String first, String second, int[][] dp) {
    int x = dp.length - 1;
    int y = dp[0].length - 1;

    List<Character> lcs = new LinkedList<>();

    while (x > 0 && y > 0) {
      if (dp[x][y] == dp[x - 1][y]) {
        // if this number came from same row, reduce the row
        x--;
      } else if (dp[x][y] == dp[x][y - 1]) {
        // if this number came from same column, reduce the column
        y--;
      }
      else if (dp[x][y] == dp[x - 1][y - 1] + 1) {
        // if this number came from addition operation
        lcs.add(0, first.charAt(x - 1)); // or second.charAt(y - 1)
        x--;
        y--;
      }
    }

    return lcs.stream().map(Object::toString).collect(Collectors.joining());
  }
}
