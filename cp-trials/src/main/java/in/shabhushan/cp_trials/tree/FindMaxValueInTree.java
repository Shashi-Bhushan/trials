package in.shabhushan.cp_trials.tree;

import java.util.Objects;

class TreeNode<T> {
  TreeNode left;
  TreeNode right;
  T value;

  public TreeNode(T value, TreeNode left, TreeNode right) {
    this.value = value;
    this.left = left;
    this.right = right;
  }

  public TreeNode(T value) {
    this.value = value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof TreeNode)) return false;
    TreeNode<?> treeNode = (TreeNode<?>) o;
    return Objects.equals(value, treeNode.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}

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
