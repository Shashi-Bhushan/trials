package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

import java.util.*;

/**
 * Leetcode Solution for
 * https://leetcode.com/problems/smallest-subtree-with-all-the-deepest-nodes/
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
class SubTreeDeepestNode {
  public TreeNode subtreeWithAllDeepest(TreeNode root) {
    Map<TreeNode, Integer> depth = new HashMap<>();

    depth.put(null, -1);
    dfs(root, depth, null);

    // get max depth
    int maxDepth = 0;
    for (int x: depth.values()) {
      maxDepth = Math.max(maxDepth, x);
    }

    return ans(root, depth, maxDepth);
  }

  private TreeNode ans(TreeNode node, Map<TreeNode, Integer> depth, int maxDepth) {
    if (node == null || depth.get(node).equals(maxDepth))
      return node;
    else {
      TreeNode l = (node.left != null) ? ans(node.left, depth, maxDepth) : null;
      TreeNode r = (node.right != null) ? ans(node.right, depth, maxDepth) : null;

      if (l != null && r != null)
        return node;
      else if (l == null)
        return r;
      else if (r == null)
        return l;
      else return null;
    }
  }

  private void dfs(TreeNode node, Map<TreeNode, Integer> depth, TreeNode parent) {
    if (node != null) {
      depth.put(node, depth.get(parent) + 1);
      dfs(node.left, depth, node);
      dfs(node.right, depth, node);
    }
  }
}
