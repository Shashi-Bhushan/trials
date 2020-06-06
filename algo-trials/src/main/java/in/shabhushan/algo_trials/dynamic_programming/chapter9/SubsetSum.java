package in.shabhushan.algo_trials.dynamic_programming.chapter9;

/**
 * Given an array of non negative integers and a positive integer X, determine if there exists a subset of elements in the
 * array with sum equal to X.
 */
public class SubsetSum {
  /**
   *
   */
  public static boolean subsetSum(int[] array, int targetSum) {
    return helper(array, 0, 0, targetSum);
  }

  private static boolean helper(int[] array, int index, int currentSum, int targetSum) {
    if (currentSum == targetSum) return true;
    else if (index == array.length) return false;

    for (int i = index; i < array.length; i++) {
      if (array[i] <= targetSum) {
        if (helper(array, i + 1, currentSum + array[i], targetSum))
          return true;
      }
    }

    return false;
  }
}
