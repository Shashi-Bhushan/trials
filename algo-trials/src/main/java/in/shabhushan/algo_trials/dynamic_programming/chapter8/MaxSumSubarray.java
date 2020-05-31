package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import java.util.Arrays;

public class MaxSumSubarray {
  /**
   * idea is M(N) = Max(M(n - 1) + array[n], array[n])
   * Please make it work :p
   */
  public static int maxSumSubarray(int[] array) {
    if (array.length == 0) return 0;

    int n = array.length;
    int leftSum = maxSumSubarray(Arrays.copyOf(array, n - 1));
    return Math.max(Math.max(leftSum, leftSum + array[n - 1]), array[n - 1]);
  }

  public static int maxSumSubarrayDP(int[] array) {
    int sum = 0;
    int best = 0;

    for (int num: array) {
      sum = Math.max(sum + num, num);
      best = Math.max(best, sum);
    }

    return best;
  }
}
