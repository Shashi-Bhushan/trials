package in.shabhushan.algo_trials.dynamic_programming;

import java.util.*;

/**
 * https://www.geeksforgeeks.org/longest-increasing-subsequence-dp-3/
 */
public class LongestIncreasingSubsequence {
  private static int max;
  private static Map<Integer, Integer> map;

  public static int lis(int arr[]) {

    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     */
    max = 1;
    map = new HashMap<>();

    helper(arr, arr.length - 1);

    return max;
  }

  private static int helper(int[] arr, int end) {
    if (end == 0) return 1;
    else if (map.containsKey(end)) return map.get(end);
    else {
      int maxHere = 1;

      for (int i = 0; i < end; i++) {
        int res = 1 + helper(arr, i);

        if (arr[i] < arr[end]) {
          maxHere = Math.max(maxHere, res);
        }
      }

      max = Math.max(max, maxHere);

      map.put(end, maxHere);

      return maxHere;
    }
  }
}
