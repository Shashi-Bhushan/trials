package in.shabhushan.cp_trials.ds.tree;

public class FindMaxValueInTree {

  static int findMax(TreeNode<Integer> root) {
    if (root == null)
      return Integer.MIN_VALUE;
    else {
      int leftMax = findMax(root.left);
      int rightMax = findMax(root.right);

      int max = Math.max(leftMax, rightMax);
      return Math.max(max, root.value);
    }
  }
}
