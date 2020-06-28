package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

/**
 * Leetcode solution for
 * https://leetcode.com/contest/weekly-contest-140/problems/insufficient-nodes-in-root-to-leaf-paths/
 */
class InsufficientNodes {
  public TreeNode sufficientSubset(TreeNode root, int limit) {
    return traverse(root, limit, 0);
  }
  
  private TreeNode traverse(TreeNode root, int limit, int sum) {
    if (root == null) return null;
    else if (root.left == null && root.right == null) {
      // insufficient node
      if (sum + root.val < limit) return null;
      else return root;
    } else {
      TreeNode left = traverse(root.left, limit, sum + root.val);
      TreeNode right = traverse(root.right, limit, sum + root.val);
      
      if (left == null && right == null) return null;
      else {
        root.left = left;
        root.right = right;
        
        return root;
      }
    }
  }
}
