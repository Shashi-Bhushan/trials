package in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * An element is a majority if it appears more than N/2 times in an array.
 * Devise an algorithm to identify the majority if it exists. Your algorithm should run in linearithmic time.
 */
public class Exercise5Majority {

  /**
   * Time Complexity O(32 * n) + O(n) for count = O(n)
   * since 32 is a constant
   *
   * Space = O(1)
   */
  public static int majority(int[] nums) {
    int n = nums.length;

    int majorityNumber = 0;

    for (int bit = 0; bit < 32; bit++) {
      int setBitCount = 0;
      for (int num: nums) {
        // check if bit is set
        if ((num & (1 << bit)) != 0) {
          setBitCount++;
        }
      }

      if (setBitCount > n/2) {
        // set this bit on majority element
        majorityNumber = majorityNumber | (1 << bit);
      }
    }

    int count = 0;

    // NOTE: Arrays.stream(nums).filter(num -> num == m).count() > n/2 turned out to be slowing factor :(
    // otherwise this solution is faster than map version by around 40%
    for (int num : nums) {
      if (num == majorityNumber)
        count++;
      if (count > n / 2)
        return majorityNumber;
    }

    return -1;
  }

  /**
   * Time Complexity
   * O(n) + O(N) = O(N)
   *
   * Space Complexity
   * O(N)
   *
   * Also, since it requires map and Integer, it's guaranteed to be slower than binary implementation anyway.
   */
  public static int majorityHashMap(int[] nums) {
    Map<Integer, Integer> frequency = new HashMap<>();

    for (int num: nums) {
      frequency.put(num, frequency.getOrDefault(num, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry: frequency.entrySet()) {
      if (entry.getValue() > nums.length / 2) {
        return entry.getKey();
      }
    }

    return -1;
  }
}
