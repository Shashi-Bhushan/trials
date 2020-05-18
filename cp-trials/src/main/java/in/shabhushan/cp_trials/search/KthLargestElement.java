package in.shabhushan.cp_trials.search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KthLargestElement {
  /**
   * O(NlogN)
   */
  public static int findKthLargest(int[] nums, int k) {
    Arrays.sort(nums);

    return nums[nums.length - k];
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

  public static int findKthLargest3(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int num: nums) {
      min = Math.min(min, num);
      max = Math.max(max, num);
    }

    int[] bucket = new int[max - min + 1];

    for (int num: nums) {
      bucket[num - min]++;
    }

    int m = 0;
    for (int i = bucket.length - 1; i >= 0; i--) {
      m += bucket[i];

      if (m >= k) {
        return i + min;
      }
    }

    return -1;
  }
}
