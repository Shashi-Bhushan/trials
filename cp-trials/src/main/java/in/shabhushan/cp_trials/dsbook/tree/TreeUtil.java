package in.shabhushan.cp_trials.dsbook.tree;

public class TreeUtil {
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
