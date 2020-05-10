package in.shabhushan.cp_trials.tree;

public class CommonParent {
  public static TreeNode commonNode(TreeNode parent, TreeNode a, TreeNode b) {
    if (isChild(parent.left, a) && isChild(parent.right, b))
      return parent;
    else {
      TreeNode x = commonNode(parent.left, a, b);

      if (x != null)
        return x;
      else {
        return commonNode(parent.right, a, b);
      }
    }
  }

  public static boolean isChild(TreeNode parent, TreeNode child) {
    if (parent == null)
      return false;
    else if (parent.equals(child))
      return true;
    else
      return isChild(parent.left, child) || isChild(parent.right, child);
  }
}
