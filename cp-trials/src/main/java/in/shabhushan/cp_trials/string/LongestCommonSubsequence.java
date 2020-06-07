package in.shabhushan.cp_trials.string;

import java.util.HashMap;
import java.util.Map;

public class LongestCommonSubsequence {
  /**
   * Recursive Solution
   * Gives TLE on very long Strings
   */
  public static int longestCommonSubsequence(String text1, String text2) {
    return helper(text1, text2, 0, 0, new HashMap<>());
  }

  private static int helper(String one, String two, int first, int second, Map<Map.Entry<Integer, Integer>, Integer> memory) {
    if (first == one.length() || second == two.length()) {
      return 0;
    } else if (one.charAt(first) == two.charAt(second)) {
      if (!memory.containsKey(Map.entry(first + 1, second + 1)))
        memory.put(Map.entry(first + 1, second + 1), helper(one, two, first + 1, second + 1, memory));

      return 1 + memory.get(Map.entry(first + 1, second + 1));
    } else {
      if (!memory.containsKey(Map.entry(first + 1, second)))
        memory.put(Map.entry(first + 1, second), helper(one, two, first + 1, second, memory));

      if (!memory.containsKey(Map.entry(first, second + 1)))
        memory.put(Map.entry(first, second + 1), helper(one, two, first, second + 1, memory));

      return Math.max(memory.get(Map.entry(first + 1, second)), memory.get(Map.entry(first, second + 1)));
    }
  }

  /**
   * The problem is in-fact NP-Complete (There is no known polynomial time solution for this problem).
   */
  public static int longestCommonSubsequence2(String text1, String text2) {
    int[][] dp = new int[text1.length() + 1][text2.length() + 1];

    for (int i = 1; i < dp.length; i++) {
      for (int j = 1; j < dp[i].length; j++) {
        if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
          dp[i][j] = 1 + dp[i-1][j-1];
        } else {
          dp[i][j] = Math.max(dp[i-1][j], dp[i][j - 1]);
        }
      }
    }

    return dp[text1.length()][text2.length()];
  }
}
