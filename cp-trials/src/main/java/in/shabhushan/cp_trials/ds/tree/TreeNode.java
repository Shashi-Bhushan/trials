package in.shabhushan.cp_trials.ds.tree;

import java.util.Objects;

public class TreeNode<T> {
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

  public TreeNode getLeft() {
    return left;
  }

  public TreeNode getRight() {
    return right;
  }

  public T getValue() {
    return value;
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
