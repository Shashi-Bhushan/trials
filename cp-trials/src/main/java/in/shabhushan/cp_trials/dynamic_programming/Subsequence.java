package in.shabhushan.cp_trials.dynamic_programming;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/is-subsequence/submissions/
 */
class Subsequence {
  public boolean isSubsequence2(String s, String t) {
    if (s.isEmpty() && t.isEmpty()) return true;
    else if (s.isEmpty()) return true;
    else if (t.isEmpty()) return false;

    System.out.println("s " + s + " t " + t);
    boolean a = (s.charAt(0) == t.charAt(0)) ? isSubsequence(s.substring(1), t.substring(1)) : false;
    boolean b = (s.charAt(0) != t.charAt(0)) ? isSubsequence(s, t.substring(1)) : false;

    return a || b;
  }

  public boolean isSubsequence(String s, String t) {
    if (s.isEmpty() && t.isEmpty()) return true;
    else if (s.isEmpty()) return true;
    else if (t.isEmpty()) return false;

    //System.out.println("s " + s + " t " + t);
    boolean[][] dp = new boolean[s.length() + 1][t.length() + 1];
    dp[0][0] = true;

    for (int i = 0; i <= s.length(); i++) {
      dp[i][0] = false;
    }

    for (int i = 0; i <= t.length(); i++) {
      dp[0][i] = true;
    }

    for (int i = 1; i <= s.length(); i++) {
      for (int j = 1; j <= t.length(); j++) {
        if (s.charAt(i - 1) == t.charAt(j - 1))
          dp[i][j] = dp[i - 1][j - 1];
        if (s.charAt(i - 1) != t.charAt(j - 1))
          dp[i][j] = dp[i][j - 1];
      }
    }

    return dp[s.length()][t.length()];
  }
}
