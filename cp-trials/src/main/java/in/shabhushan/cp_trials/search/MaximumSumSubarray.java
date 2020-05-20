package in.shabhushan.cp_trials.search;

public class MaximumSumSubarray {
  public static int maximumSumSubarray(int[] array) {
    int best = 0;

    for (int i = 0; i < array.length; i++) {
      int sum = 0;

      for (int j = i; j < array.length; j++) {
        sum = sum + array[j];
        best = Math.max(sum, best);
      }
    }

    return best;
  }

  /**
   * Intuition if the sum is decreasing by adding the array[i], then just take array[i]
   */
  public static int maximumSumSubarray2(int[] array) {
    int best = 0;
    int sum = 0;

    for (int i = 0; i < array.length; i++) {
      sum = Math.max(array[i], sum + array[i]);
      best = Math.max(best, sum);
    }

    return best;
  }
}
