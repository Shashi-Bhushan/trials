package in.shabhushan.cp_trials.tree.gfg;

import in.shabhushan.cp_trials.ds.tree.TreeNode;

import java.util.Arrays;

public class ArrayToBST {
  /**
   * Given a sorted array. Write a function that creates a Balanced Binary Search Tree using array elements.
   * https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/
   *
   * Also, the the tree would be a Balanced AVL Tree since it maintains the balance factor
   * Given an array of integers, the task is to find the sequence in which these integers should be added to an AVL tree such that no rotations are required to balance the tree.
   * https://www.geeksforgeeks.org/optimal-sequence-for-avl-tree-insertion-without-any-rotations/
   */
  public static TreeNode<Integer> sortedArrayToBST(int[] array) {
    Arrays.sort(array);
    return helper(array, 0, array.length - 1);
  }

  private static TreeNode<Integer> helper(int[] array, int left, int right) {
    if (left > right) {
      return null;
    } else {
      int mid = left + (right - left) / 2;

      TreeNode<Integer> root = new TreeNode<>(array[mid]);

      root.left = helper(array, left, mid - 1);
      root.right = helper(array, mid + 1, right);

      return root;
    }
  }
}
