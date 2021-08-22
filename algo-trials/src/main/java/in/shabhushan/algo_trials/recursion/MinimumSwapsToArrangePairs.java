package in.shabhushan.algo_trials.recursion;

import java.util.Map;

/**
 * https://www.geeksforgeeks.org/minimum-number-of-swaps-required-for-arranging-pairs-adjacent-to-each-other/
 *
 * Input:
 * n = 3
 * pairs[] = {1->3, 2->6, 4->5}  // 1 is partner of 3 and so on
 * arr[] = {3, 5, 6, 4, 1, 2}
 *
 * Output: 2
 * We can get {3, 1, 5, 4, 6, 2} by swapping 5 & 6, and 6 & 1
 */
public class MinimumSwapsToArrangePairs {
  /**
   * Better to try to arrange one of 3 or 5 in first go
   */
  public static int getMinimumSwapsToArrangePairs(Map<Integer, Integer> pairs, int[] arr) {
    return helper(pairs, arr, 0);
  }

  private static int helper(Map<Integer, Integer> pairs, int[] arr, int index) {
    if (index == arr.length) {
      return 0;
    } else if (pairs.get(arr[index]) == arr[index + 1]) {
      // if pairs match
      return helper(pairs, arr, index + 2);
    } else {
      // find partner of first number
      int partner = pairs.get(arr[index]);
      int partnerIndex = -1;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == partner) {
          partnerIndex = i;
          break;
        }
      }

      swap(arr, index + 1, partnerIndex);

      int first = helper(pairs, arr, index + 2);

      swap(arr, index + 1, partnerIndex);

      // find partner of second number
      partner = pairs.get(arr[index + 1]);
      partnerIndex = -1;

      for (int i = 0; i < arr.length; i++) {
        if (arr[i] == partner) {
          partnerIndex = i;
          break;
        }
      }

      swap(arr, index, partnerIndex);

      int second = helper(pairs, arr, index + 2);

      swap(arr, index, partnerIndex);

      return 1 + Math.min(first, second);
    }
  }

  private static void swap(int[] arr, int first, int second) {
    int temp = arr[first];
    arr[first] = arr[second];
    arr[second] = temp;
  }
}
