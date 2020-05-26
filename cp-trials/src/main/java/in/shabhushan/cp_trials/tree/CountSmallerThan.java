package in.shabhushan.cp_trials.tree;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/submissions/
 *
 * Check https://www.youtube.com/watch?v=buDoT9ESw1c for reference
 */
class CountSmallerThan {
  public static List<Integer> countSmaller(int[] nums) {
    List<Integer> result = new ArrayList<>();
    if (nums.length == 0 || nums == null)
      return result;

    Node root = new Node(nums[nums.length - 1]);

    result.add(0);

    for (int i = nums.length - 2; i >=0; i--) {
      result.add(insertNodeAndGetCount(root, nums[i]));
    }

    Collections.reverse(result);

    return result;
  }

  private static int insertNodeAndGetCount(Node node, int value) {
    int smallerCount = 0;

    Node temp = new Node(value);
    boolean addedInTree = false;

    while (!addedInTree) {
      if (temp.data <= node.data) {
        node.count++;

        if (node.left == null) {
          node.left = temp;
          addedInTree = true;
        } else {
          node = node.left;
        }
      } else {
        smallerCount += node.count;

        if (node.right == null) {
          node.right = temp;
          addedInTree = true;
        } else {
          node = node.right;
        }
      }
    }

    return smallerCount;
  }

  private static class Node {
    Node left;
    Node right;
    int data;
    int count = 1;

    public Node(int data) {
      this.data = data;
    }
  }
}
