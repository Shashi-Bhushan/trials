package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

public class Exercise18LocalMinimum {
  /**
   * Think of the problem like a valley
   * if the numbers are all increasing, then valley height is growing and growing. lowest height would be at point 0.
   * Similarly if it's decreasing then it's at last point.
   *
   * But if there are ups and downs in the valley, there must be atleast one point before which it's downhill and after which it's uphill.
   * Find that point.
   */
  public static int localMinimum(int[] array) {
    if (array.length == 1)
      return array[0];
    if (array.length == 2) {
      return Math.min(array[0], array[1]);
    }

    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (mid == 0) {
        if (array[mid] < array[mid + 1])
          return array[mid];
        else
          return -1;
      } else if (mid == array.length - 1) {
        if (array[mid] < array[mid - 1])
          return array[mid];
        else
          return -1;
      }

      if (array[mid] < array[mid - 1] && array[mid] < array[mid + 1]){
        return array[mid];
      } else if (array[mid - 1] < array[mid]){
        high = mid - 1;
      } else if (array[mid + 1] < array[mid]) {
        low = mid + 1;
      }
    }

    return -1;
  }
}
