package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

/**
 * Binary Search the first occurrence of an element in a sorted array with duplicates
 */
public class Exercise10BinarySearch {

  public static int binarySearchFirstIndex(int[] array, int element) {
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == element) {
        // check bound for mid - 1
        if (mid - 1 < low || array[mid - 1] != element)
        // short for  ((low <= mid - 1 && array[mid - 1] != element) || (mid - 1 < low))
          return mid;
        else if (low <= mid - 1)
          high = mid - 1;
      } else if (array[mid] < element) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }

    return -1;
  }
}
