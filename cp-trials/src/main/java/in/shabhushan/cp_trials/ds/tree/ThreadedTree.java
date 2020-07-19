package in.shabhushan.cp_trials.ds.tree;

import java.util.ArrayList;
import java.util.List;

public class ThreadedTree {

  /**
   * Case 1: Insertion in empty tree
   * Both left and right pointers of tmp will be set to NULL and new node becomes the root.
   *
   *
   * Case 2: When new node inserted as the left child
   * After inserting the node at its proper place we have to make its left and right threads points to inorder predecessor and successor respectively.
   * Predecessor of parent becomes the predecessor of child
   *
   *
   * Case 3: When new node is inserted as the right child
   * The parent of tmp is its inorder predecessor. The node which was inorder successor of the parent is now the inorder successor of this node tmp.
   * Successor of parent becomes the successor of child
   */
  public static <T extends Integer> ThreadedTreeNode<T> insert(ThreadedTreeNode<T> root, T value) {
    ThreadedTreeNode<T> parent = null;
    ThreadedTreeNode<T> node = root;

    while (node != null) {
      if (node.data.equals(value)) {
        throw new IllegalArgumentException("Value already exists in Tree");
      }

      parent = node;

      // node data is smaller than value, go to right
      if (node.data.compareTo(value) < 0) {
        if (node.rightThread == false)
          node = node.right;
        else
          break;
      } else if (node.data.compareTo(value) > 0) {
        if (node.leftThread == false)
          node = node.left;
        else
          break;
      }
    }

    ThreadedTreeNode<T> newNode = new ThreadedTreeNode<>(value);
    newNode.leftThread = true;
    newNode.rightThread = true;

    if (parent == null) {
      root = newNode;
      newNode.leftThread = false;
      newNode.rightThread = false;
    } else if (parent.data.compareTo(value) < 1) {
      // parent is smaller, add to right
      newNode.left = parent;
      newNode.right = parent.right; // copy successor

      // right is not a thread anymore
      parent.rightThread = false;
      parent.right = newNode;
    } else {
      // parent is larger, add to left
      newNode.right = parent;
      newNode.left = parent.left; // cope predecessor

      // left is not a thread anymore
      parent.leftThread = false;
      parent.left = newNode;
    }

    return root;
  }

  public static <T> List<T> inorderTraversal(ThreadedTreeNode<T> root) {
    ThreadedTreeNode<T> node = root;

    List<T> list = new ArrayList<>();

    // reach left most node
    while (node.leftThread == false && node.left != null) {
      node = node.left;
    }

    while (node != null) {
      list.add(node.data);

      node = inorderSuccessor(node);
    }

    return list;
  }

  private static <T> ThreadedTreeNode<T> inorderSuccessor(ThreadedTreeNode<T> node) {
    if (node.rightThread == true) {
      return node.right;
    } else {
      node = node.right;

      while (node.leftThread == false) {
        node = node.left;
      }

      return node;
    }
  }

  public static <T> void inorderTraverse(ThreadedTreeNode<T> node) {
    if (node != null) {
      if (node.leftThread == false)
        inorderTraverse(node.left);

      System.out.println(node.data);

      if (node.rightThread == false)
        inorderTraverse(node.right);
    }
  }
}
