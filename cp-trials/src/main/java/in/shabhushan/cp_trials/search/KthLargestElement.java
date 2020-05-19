package in.shabhushan.cp_trials.search;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthLargestElement {
  /**
   * O(NlogN)
   */
  public static int findKthLargest(int[] nums, int k) {
    int[] numsCopy = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      numsCopy[i] = nums[i];
    }

    Arrays.sort(numsCopy);

    return numsCopy[numsCopy.length - k];
  }

  /**
   * O(NlogK)
   */
  public static int findKthLargest2(int[] nums, int k) {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> a - b);

    for (int num: nums) {
      minHeap.add(num);

      if (minHeap.size() > k) {
        minHeap.poll();
      }
    }

    return minHeap.poll();
  }

  /**
   * O(N)
   */
  public static int findKthLargest3(int[] nums, int k) {
    int left = 0;
    int right = nums.length - 1;

    return helper(nums, k, left, right);
  }

  private static int helper(int[] nums, int k, int left, int right) {


    while (left <= right) {
      // consider left as pivot
      // move it to right
      swap(nums, left, right);

      int pivot = nums[right];
      int listTail = left;

      for (int i = left; i < right; i++) {
        if (nums[i] <= pivot) {
          swap(nums, i, listTail);
          listTail++;
        }
      }

      swap(nums, listTail, right);

      if (listTail == nums.length - k) {
        return nums[listTail];
      } else if (listTail < nums.length - k) {
        left = listTail + 1;
      } else {
        right = listTail - 1;
      }
    }

    return left;
  }

  private static void swap(int[] nums, int left, int right) {
    int temp = nums[left];
    nums[left] = nums[right];
    nums[right] = temp;
  }
}
