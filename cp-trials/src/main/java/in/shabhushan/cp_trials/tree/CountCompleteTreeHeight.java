package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/count-complete-tree-nodes/
 *
 * Check this for reference
 * https://leetcode.com/problems/count-complete-tree-nodes/discuss/701493/Idea-Explained-or-100-faster-or-O(log(n)-2)-or-Use-Complete-Tree-Property
 *
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CountCompleteTreeHeight {
  public int countNodes(TreeNode root) {
    if (root == null) return 0;

    int height = height(root);

    int rightHeight = height(root.right);

    if (rightHeight == height - 1) return (1 << (height - 1)) + countNodes(root.right);
    else return (1 << (height - 2)) + countNodes(root.left);
  }

  private int height(TreeNode node) {
    int level = 0;

    while (node != null) {
      node = node.left;
      level++;
    }

    return level;
  }
}
