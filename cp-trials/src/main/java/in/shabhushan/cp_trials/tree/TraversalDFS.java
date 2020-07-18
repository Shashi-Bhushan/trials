package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Traverse a Tree in DFS using iterations
 */
public class TraversalDFS {

  public static List<Integer> preOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode<Integer> node = stack.pop();

      processNode(answer, node);

      if (node.right != null) {
        stack.push(node.right);
      }

      if (node.left != null) {
        stack.push(node.left);
      }
    }

    return answer;
  }

  public static List<Integer> inOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> current = root;

    while (current != null || !stack.isEmpty()) {
      while (current != null) {
        stack.push(current);
        current = current.left;
      }

      current = stack.pop();

      processNode(answer, current);
      current = current.right;
    }

    return answer;
  }

  public static List<Integer> postOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();
    Deque<TreeNode<Integer>> secondStack = new ArrayDeque<>();

    stack.push(root);

    while (!stack.isEmpty()) {
      TreeNode<Integer> node = stack.pop();
      secondStack.push(node);

      if (node.left != null)
        stack.push(node.left);

      if (node.right != null)
        stack.push(node.right);
    }

    while (!secondStack.isEmpty()) {
      processNode(answer, secondStack.pop());
    }

    return answer;
  }

  private static void processNode(List<Integer> answer, TreeNode<Integer> node) {
    answer.add(node.value);
  }
}
