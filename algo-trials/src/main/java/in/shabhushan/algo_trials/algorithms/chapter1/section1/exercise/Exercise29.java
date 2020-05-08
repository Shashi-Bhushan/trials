package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

public class Exercise29 {
  /**
   * Don't stop the loop at arr[mid] = element
   *
   * Similarly do for greater than
   */
  public static int lessThan(int element, int[] array) {
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (element < array[mid]) {
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    return low;
  }
}
