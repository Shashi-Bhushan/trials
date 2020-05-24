package in.shabhushan.cp_trials.competition.leetcode;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.Set;

public class Weekly190 {
  private static final Set<Character> vowels = Set.of('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');

  public int maxVowels(String s, int k) {
    int[] rank = new int[s.length() + 1];

    for (int i = 0; i < s.length(); i++) {
      rank[i + 1] = rank[i] + ((vowels.contains(s.charAt(i))) ? 1 : 0);
    }

    int max = 0;
    for (int i = k; i <= s.length(); i++) {
      max = Math.max(max, rank[i] - rank[i - k]);
    }

    return max;
  }

  public static class PseudoTreeNode {
      int val;
      PseudoTreeNode left;
      PseudoTreeNode right;
      PseudoTreeNode() {}
      PseudoTreeNode(int val) { this.val = val; }
      PseudoTreeNode(int val, PseudoTreeNode left, PseudoTreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

  /**
   * Solution for
   * https://leetcode.com/contest/weekly-contest-190/problems/pseudo-palindromic-paths-in-a-binary-tree/
   */
  public static int pseudoPalindromicPaths(PseudoTreeNode root) {
    return dfs(root, 0, 0);
  }

  /**
   * Map the tree to multiples of 2 and then xor check if the last value is indeed multiple of 2.
   */
  private static int dfs(PseudoTreeNode node, int currentCount, int totalCount) {
    if (node == null)
      return 0;

    currentCount ^= (1 << node.val);

    if ((currentCount & (currentCount - 1)) == 0 && node.left == null && node.right == null) {
      return totalCount + 1;
    } else {
      return dfs(node.left, currentCount, totalCount) + dfs(node.right, currentCount, totalCount);
    }
  }
}
