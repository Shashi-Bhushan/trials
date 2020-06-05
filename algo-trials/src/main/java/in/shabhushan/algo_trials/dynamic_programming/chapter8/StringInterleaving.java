package in.shabhushan.algo_trials.dynamic_programming.chapter8;

/**
 * Leetcode solution
 * https://leetcode.com/problems/interleaving-string/
 */
public class StringInterleaving {
  // Greedy won't work, check isInterleavingString("bcc", "bbca", "bbcbcac")
  public static boolean isInterleavingStringGreedy(String a, String b, String c) {
    if (a.length() + b.length() != c.length())
      return false;

    int x = 0;
    int y = 0;
    int z = 0;

    while (z < c.length()) {
      char ch = c.charAt(z);

      // check if character in a is equal to character in c
      if (x < a.length() && a.charAt(x) == ch) {
        x++;
      } else if (y < b.length() && b.charAt(y) == ch) {
        y++;
      } else {
        return false;
      }

      z++;
    }

    return x == a.length() && y == b.length() && z == c.length();
  }

  public static boolean isInterleavingString(String a, String b, String c) {
    if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
    else if (c.isEmpty()) return false;
    else if (a.isEmpty() && b.isEmpty()) return false;
    else if (a.length() + b.length() != c.length()) return false;
    else {
      boolean first = (firstChar(a) == firstChar(c)) && isInterleavingString(dropFirstChar(a), b, dropFirstChar(c));

      boolean second = (firstChar(b) == firstChar(c)) && isInterleavingString(a, dropFirstChar(b), dropFirstChar(c));

      return first || second;
    }
  }

  public static boolean isInterleavingStringDP(String a, String b, String c) {
    if (a.isEmpty() && b.isEmpty() && c.isEmpty()) return true;
    else if (a.length() + b.length() != c.length()) return false;
    else {
      boolean[][] dp = new boolean[a.length() + 1][b.length() + 1];
      dp[0][0] = true; // empty string to empty string interleaving

      for (int i = 1; i <= a.length(); i++) {
        if (a.charAt(i - 1) != c.charAt(i - 1)) dp[i][0] = false;
        else dp[i][0] = dp[i-1][0];
      }

      for (int j = 1; j <= b.length(); j++) {
        if (b.charAt(j - 1) != c.charAt(j - 1)) dp[0][j] = false;
        else dp[0][j] = dp[0][j-1];
      }

      for (int i = 1; i <= a.length(); i++) {
        for (int j = 1; j <= b.length(); j++) {
          // current char of a = c, but not of b
          char ch = c.charAt(i + j - 1);
          if (a.charAt(i - 1) == ch && b.charAt(j - 1) != ch) dp[i][j] = dp[i - 1][j];
          else if (b.charAt(j - 1) == ch && a.charAt(i - 1) != ch) dp[i][j] = dp[i][j - 1];
          else if (a.charAt(i - 1) == ch && b.charAt(j - 1) == ch) dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
          else dp[i][j] = false;
        }
      }

      return dp[a.length()][b.length()];
    }
  }

  // if string is empty, give a `empty char` instead of first char(Exception)
  public static char firstChar(String s) {
    return (s.length() != 0) ? s.charAt(0) : ' ';
  }

  public static String dropFirstChar(String s) {
    return s.substring(1);
  }
}
