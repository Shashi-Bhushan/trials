package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTfromPreOrder {
  /**
   * Check video reference on
   * https://www.udemy.com/course/datastructurescncpp/learn/lecture/13190120#overview
   */
  public static TreeNode<Integer> getBst(int[] preorder) {
    int i = 0;

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> root = new TreeNode<>(preorder[i++]);
    TreeNode<Integer> prev = root;

    while (i < preorder.length) {
      if (preorder[i] < prev.value) {
        TreeNode<Integer> t = new TreeNode<>(preorder[i++]);

        prev.left = t;
        stack.push(prev);
        prev = t;
      } else {
        while (!stack.isEmpty() && preorder[i] > stack.peek().value) {
          prev = stack.pop();
        }

        TreeNode<Integer> t = new TreeNode<>(preorder[i++]);

        prev.right = t;
        prev = t;
      }
    }

    return root;
  }
}
