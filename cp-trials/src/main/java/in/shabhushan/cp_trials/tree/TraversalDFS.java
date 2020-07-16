package in.shabhushan.cp_trials.tree;

import com.sun.source.tree.Tree;
import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Traverse a Tree in DFS using iterations
 */
public class TraversalDFS {

  public static void preOrder(TreeNode<Integer> root) {
    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode<Integer> node = stack.pop();

      processNode(node);

      if (node.right != null) {
        stack.push(node.right);
      }

      if (node.left != null) {
        stack.push(node.left);
      }
    }
    System.out.println();
  }

  public static void inOrder(TreeNode<Integer> root) {
    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      current = stack.pop();

      processNode(current);
      current = current.right;
    }
    System.out.println();
  }

  private static void processNode(TreeNode<Integer> node) {
    System.out.print(node.value + " ");
  }
}
