package in.shabhushan.algo_trials.dynamic_programming.chapter9;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/longest-palindromic-subsequence/submissions/
 */
public class LongestPalindromicSubsequence {
  public static int lps(String a) {
    if (a.length() == 0 || a.length() == 1) return a.length();
    else if (a.charAt(0) == a.charAt(a.length() - 1))
      return lps(a.substring(1, a.length() - 1)) + 2;
    else return Math.max(
          lps(a.substring(1)),
          lps(a.substring(0, a.length() - 1))
      );
  }

  /**
   * Check this for reference
   * https://www.youtube.com/watch?v=TLaGwTnd3HY
   * https://leetcode.com/problems/longest-palindromic-subsequence/discuss/304451/O(n2)-TIME-O(n)-SPACE-DYNAMIC-PROGRAMMING-JAVA-SOLUTION
   */
  public static int lpsDP(String s) {
    if (s.length() == 0 || s.length() == 1) return s.length();

    int len = s.length();
    int[][] dp = new int[len][len];

    for (int i = 0; i < len; i++) {
      dp[i][i] = 1;
    }

    for (int diff = 1; diff < len; diff++) {
      for (int i = 0; i + diff < len; i++) {
        int j = i + diff;

        if (s.charAt(i) == s.charAt(j)) {
          dp[i][j] = dp[i + 1][j - 1] + 2;
        } else {
          dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
        }
      }
    }
    return dp[0][len - 1];
  }
}
