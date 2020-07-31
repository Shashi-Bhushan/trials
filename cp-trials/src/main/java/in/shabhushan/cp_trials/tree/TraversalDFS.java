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

  /**
   * Check this for reference
   * https://www.udemy.com/course/datastructurescncpp/learn/lecture/13168610#overview
   */
  public static List<Integer> preOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> node = root;

    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        processNode(answer, node);
        stack.push(node);
        node = node.left;
      } else {
        node = stack.pop();
        node = node.right;
      }
    }

    return answer;
  }

  public static List<Integer> inOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> node = root;

    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(node);
        node = node.left;
      } else {
        node = stack.pop();
        processNode(answer, node); // only this step differs from preorder traversal

        node = node.right;
      }
    }

    return answer;
  }

  /**
   * check this for reference
   * https://www.udemy.com/course/datastructurescncpp/learn/lecture/13168646#overview
   */
  public static List<Integer> postOrder(TreeNode<Integer> root) {
    List<Integer> answer = new ArrayList<>();

    Deque<TreeInfo> stack = new ArrayDeque<>();

    TreeNode<Integer> node = root;

    while (node != null || !stack.isEmpty()) {
      if (node != null) {
        stack.push(new TreeInfo(node, false));
        node = node.left;
      } else {
        TreeInfo info = stack.pop();

        if (!info.print) {
          stack.push(new TreeInfo(info.node, true));
          node = info.node.right;
        } else {
          processNode(answer, info.node);
          node = null;
        }
      }
    }

    return answer;
  }

  private static class TreeInfo {
    TreeNode<Integer> node;
    boolean print;

    public TreeInfo(TreeNode<Integer> node, boolean print) {
      this.node = node;
      this.print = print;
    }
  }

  public static List<Integer> levelOrder(TreeNode<Integer> root) {
    Deque<TreeNode<Integer>> queue = new ArrayDeque<>();
    queue.offer(root);

    List<Integer> list = new ArrayList<>();

    while (!queue.isEmpty()) {
      int size = queue.size();

      for (int i = 0; i < size; i++) {
        TreeNode<Integer> node = queue.poll();

        list.add(node.value);

        if (node.left != null) {
          queue.offer(node.left);
        }

        if (node.right != null) {
          queue.offer(node.right);
        }
      }
    }

    return list;
  }

  private static void processNode(List<Integer> answer, TreeNode<Integer> node) {
    answer.add(node.value);
  }
}
