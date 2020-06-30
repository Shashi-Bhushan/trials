package in.shabhushan.cp_trials.array;

import java.util.*;

/**
 * Java solution for
 * https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/537/week-4-may-22nd-may-28th/3341/
 *
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 */
class ContiguousArray {
  public static int findMaxLength2(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, -1);

    int count = 0;
    int maximumLength = 0;
    for (int i = 0; i < nums.length; i++) {
      count = count + (nums[i] == 1 ? 1 : -1);

      if (map.containsKey(count)) {
        maximumLength = Math.max(maximumLength, i - map.get(count));
      } else {
        map.put(count, i);
      }
    }

    return maximumLength;
  }

  public int findMaxLength(int[] nums) {
    int level = nums.length;

    if (level < 2)
      return 0;

    int[] countMap = new int[level * 2 + 1];
    Arrays.fill(countMap, -1);

    int ans = 0;
    countMap[level] = 0;

    for (int i = 0; i < nums.length; i++) {
      level += (nums[i] == 1) ? 1 : -1;

      if (countMap[level] == -1) {
        countMap[level] = i + 1;
      } else {
        ans = Math.max(ans, (i + 1) - countMap[level]);
      }
    }

    return ans;
  }
}
