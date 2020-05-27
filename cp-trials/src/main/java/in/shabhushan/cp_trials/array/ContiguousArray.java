package in.shabhushan.cp_trials.array;

import java.util.*;

class ContiguousArray {
  public static int findMaxLength(int[] nums) {
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
}
