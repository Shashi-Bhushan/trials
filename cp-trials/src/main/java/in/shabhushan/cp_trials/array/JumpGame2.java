package in.shabhushan.cp_trials.array;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/jump-game-ii
 */
class JumpGame2 {
  /**
   * Based on Breadth first search solution
   * Gives TLE
   */
  public int jump(int[] nums) {
    ArrayDeque<List<Integer>> s = new ArrayDeque<>();
    boolean[] visited = new boolean[nums.length];

    s.add(List.of(0, nums[0]));
    visited[0] = true;

    int count = 0;
    while (!s.isEmpty()) {
      ArrayDeque<List<Integer>> temp = new ArrayDeque<>();

      while (!s.isEmpty()) {
        List<Integer> l = s.pop();

        if (l.get(0) == nums.length - 1) {
          return count;
        } else {
          // from index `first` till 'last'
          int idx = 0;
          int base = l.get(0);

          while (idx < l.get(1)) {
            int b = base + idx + 1;

            if (b < nums.length && !visited[b]) {
              temp.add(List.of(b, nums[b]));
              visited[b] = true;
            }
            idx++;
          }
        }

      }

      s = temp;
      count++;
    }

    return -1;
  }

  public int jump2(int[] nums) {
    if(nums.length == 1)
      return 0;

    int begin = 1;
    int maxJump = nums[0];
    int ans = 1;

    while (maxJump < nums.length - 1) {
      int end = maxJump;

      for (int i = begin; i <= end; i++) {
        maxJump = Math.max(maxJump, i + nums[i]);
      }

      begin = end + 1;
      ans++;
    }

    return ans;
  }
}
