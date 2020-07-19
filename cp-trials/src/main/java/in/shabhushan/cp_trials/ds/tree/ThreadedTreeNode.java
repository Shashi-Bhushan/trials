package in.shabhushan.cp_trials.ds.tree;

import java.util.Objects;

public class ThreadedTreeNode<T> {
  public ThreadedTreeNode<T> left;
  public ThreadedTreeNode<T> right;

  public boolean leftThread;
  public boolean rightThread;

  public T data;

  public ThreadedTreeNode(T data) {
    this.data = data;
  }

  public ThreadedTreeNode(ThreadedTreeNode<T> left, ThreadedTreeNode<T> right, T data) {
    this.left = left;
    this.right = right;
    this.data = data;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ThreadedTreeNode<?> that = (ThreadedTreeNode<?>) o;
    return leftThread == that.leftThread &&
      rightThread == that.rightThread &&
      Objects.equals(left, that.left) &&
      Objects.equals(right, that.right) &&
      Objects.equals(data, that.data);
  }

  @Override
  public int hashCode() {
    return Objects.hash(leftThread, rightThread, data);
  }
}
