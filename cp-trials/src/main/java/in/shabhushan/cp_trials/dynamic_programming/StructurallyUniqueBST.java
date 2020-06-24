package in.shabhushan.cp_trials.dynamic_programming;

/**
 * Leetcode solution for
 * https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3370/
 *
 * check for reference
 * https://leetcode.com/problems/unique-binary-search-trees/discuss/703098/Idea-Explained-or-O(n-2)-or-Dynamic-Programming
 */
class StructurallyUniqueBST {
  public int numTrees(int n) {
    if (n == 0 || n == 1) return 1;

    int[] dp = new int[n + 1];
    dp[0] = dp[1] = 1;

    for (int i = 2; i <= n; i++) {
      for (int j = 0; j < i; j++) {
        dp[i] += (dp[j] * dp[i - j - 1]);
      }
    }

    return dp[n];
  }
}
