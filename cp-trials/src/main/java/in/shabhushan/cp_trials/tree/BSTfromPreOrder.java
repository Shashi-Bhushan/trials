package in.shabhushan.cp_trials.tree;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

public class BSTfromPreOrder {
  public static TreeNode<Integer> getBst(int[] preorder) {
    int i = 0;

    TreeNode<Integer> root = new TreeNode<>(preorder[i++]);

    Deque<TreeNode<Integer>> stack = new ArrayDeque<>();

    TreeNode<Integer> prev = root;

    while (i < preorder.length) {
      // integer is strictly lesser, hence add element to left
      if (preorder[i] < prev.value) {
        TreeNode<Integer> temp = new TreeNode<>(preorder[i++]);

        prev.left = temp;
        stack.push(prev);

        prev = temp;
      } else {
        // Now, preorder[i] is greater than prev.value
        // we need to check if it's greater than stack.peek().value
        while (!stack.isEmpty() && preorder[i] > stack.peek().value) {
          prev = stack.pop();
        }

        // add element to prev's right
        TreeNode<Integer> temp = new TreeNode<>(preorder[i++]);

        prev.right = temp;

        prev = temp;
      }
    }

    return root;
  }
}
