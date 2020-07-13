package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class InorderSuccessor {
  // Simulate inorder traversal
  // Though it will find the solution, it does not take the property of BST into account
  public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
    if (root == null) return null;
    
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    
    boolean found = false;
    
    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }
      
      current = stack.pop();
      
      if (found) {
        return current;
      }
      else if (current != null && current.val == p.val) {
        found = true;
      }
      //System.out.println(current.val);
      current = current.right;
    }
    
    return null;
  }

  // Takes into account BST property
  public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
    if (root == null) return null;

    TreeNode candidate = null;
    TreeNode current = root;

    while (current != null) {
      // Keep going left until you find the node with less value than p
      if (current.val > p.val) {
        candidate = current;
        current = current.left;
      } else {
        current = current.right;
      }
    }

    return candidate;
  }
}
