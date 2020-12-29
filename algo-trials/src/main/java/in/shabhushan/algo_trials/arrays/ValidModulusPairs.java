package in.shabhushan.algo_trials.arrays;

import java.util.*;

/**
 * You are given an array arr of N integers and two integers K and M,
 * you need to return true if the given array can be divided into pairs such that the sum of every pair gives remainder M when divided by K.
 * Otherwise, you need to return false.
 *
 * Every element of the array should contribute to only one pair, i.e if the array is [3, 0, 0] and K = 2 and M = 1, then you need to return false,
 * as element 3 will make a pair with any one of the 0.
 *
 * For example:
 * If the given array is [2, 1, 5, 7] and K = 9 and M = 3.
 * Then you need to return true because we can divide the array into two pairs, i.e (2, 1) and (5, 7) whose sums are 3 and 12,
 * which when divided by 9 gives remainder 3, thus it is possible to divide the given array into pairs.
 */
public class ValidModulusPairs {
  public static boolean isValidPair(int[] arr, int n, int k, int m) {
    // Write your code here
    // Map<Remainder with k, it's frequency>
    if ((n & 1) == 1) return false;

    Map<Integer, Integer> map = new HashMap<>();

    for (int i: arr) {
      int x = i % k;

      map.put(x, map.getOrDefault(x, 0) + 1);
    }

    for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
      int alt = (m - entry.getKey() + k) % k;

      if (map.get(alt).intValue() != entry.getValue()) {
        return false;
      }
    }

    return true;
  }
}
