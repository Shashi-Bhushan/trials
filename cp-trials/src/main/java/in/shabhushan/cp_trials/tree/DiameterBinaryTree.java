package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.dsbook.tree.TreeNode;

import java.util.Map;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/diameter-of-binary-tree/
 */
public class DiameterBinaryTree {
  /**
   * We wer basically doing the extra work of first calling the recursive function for height
   * and then the function for diameter, which will itself call height again.
   *
   * So, returning a Pair<Height, Diameter> is much better solution
   */
  public int diameterOfBinaryTree2(TreeNode root) {
    if (root == null) return 0;
    else
      return helper(root).getValue();
  }

  // Pair of <Height, Diameter>
  // Since we were
  public Map.Entry<Integer, Integer> helper(TreeNode root) {
    if (root == null)
      return Map.entry(0, 0);
    else {
      Map.Entry<Integer, Integer> left = helper(root.left);
      Map.Entry<Integer, Integer> right = helper(root.right);

      return Map.entry(
        // height
        Math.max(left.getKey(), right.getKey()) + 1,
        // diameter
        Math.max(left.getKey() + right.getKey(), Math.max(left.getValue(), right.getValue()))
      );
    }
  }

  public static int diameterOfBinaryTree(TreeNode root) {
    if (root == null)
      return 0;
    else {
      int leftHeight = getHeight(root.left);
      int rightHeight = getHeight(root.right);

      int leftDiameter = diameterOfBinaryTree(root.left);
      int rightDiameter = diameterOfBinaryTree(root.right);

      return Math.max(leftHeight + rightHeight, Math.max(leftDiameter, rightDiameter));
    }
  }

  private static int getHeight(TreeNode node) {
    if (node == null)
      return 0;
    else return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
  }
}
