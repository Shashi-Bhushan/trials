package in.shabhushan.cp_trials.dfs;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.*;

/**
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
class BFSTree {
  public List<List<Integer>> levelOrder(TreeNode root) {
    Queue<TreeNode> stack = new ArrayDeque<>();

    stack.add(root);

    List<List<Integer>> ans = new ArrayList<>();

    while (!stack.isEmpty()) {
      Queue<TreeNode> temp = new ArrayDeque<>();

      List<Integer> a = new ArrayList<>();

      while (!stack.isEmpty()) {
        TreeNode<Integer> node = stack.poll();
        a.add(node.getValue());

        if (node.getRight() != null) {
          temp.add(node.getRight());
        }
        if (node.getLeft() != null) {
          temp.add(node.getLeft());
        }
      }

      stack = temp;
      ans.add(a);
    }

    return ans;
  }
}
