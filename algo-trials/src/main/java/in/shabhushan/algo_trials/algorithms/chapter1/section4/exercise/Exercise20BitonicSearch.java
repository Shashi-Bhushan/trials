package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

/**
 * An array is bitonic if it comprises of an increasing sequence of integers followed by a decreasing sequence of integers
 *
 * Assumptions
 * 1. Tipping point is only when array is increasing and then it decreases, not vice versa.
 * 2. if the array is decreasing from start, consider first position as tipping point.
 * 3. if the array does not decrease till end, consider last position as tipping point.
 */
public class Exercise20BitonicSearch {

  public static int bitonicSearch(int[] array, int x) {
    int tippingPoint = getTippingPoint(array);

    int position = binarySearchIncreasing(array, 0, tippingPoint, x);

    if (position == -1) {
      position = binarySearchDecreasing(array, tippingPoint + 1, array.length - 1, x);
    }

    return position;
  }

  private static int binarySearchIncreasing(int[] array, int low, int high, int element) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == element) {
        return mid;
      } else if (element < array[mid]) {
        high = mid - 1;
      } else if (array[mid] < element) {
        low = mid + 1;
      }
    }

    return -1;
  }

  private static int binarySearchDecreasing(int[] array, int low, int high, int element) {
    while (low <= high) {
      int mid = low + (high - low) / 2;

      if (array[mid] == element) {
        return mid;
      } else if (element < array[mid]) {
        low = mid + 1;
      } else if (array[mid] < element) {
        high = mid - 1;
      }
    }

    return -1;
  }

  public static int getTippingPoint(int[] array) {
    // if (array has only one entry, return 0)
    if (array.length == 1)
      return 0;

    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      int mid = low + (high - low) / 2;

      // corner case
      // if the array is decreasing from start, consider first position as tipping point.
      if (mid == 0) {
        if (array[mid + 1] < array[mid]) {
          return mid;
        } else {
          // NOTE: continue after updating low, since mid should be calculated again
          low = mid + 1;
          continue;
        }
      } else if (mid == array.length - 1) {
        // if the array does not decrease till end, consider last position as tipping point.
        if (array[mid - 1] < array[mid]) {
          return mid;
        } else {
          high = mid - 1;
          continue;
        }
      }

      if (array[mid - 1] < array[mid] && array[mid] < array[mid + 1]) {
        low = mid + 1;
      } else if (array[mid - 1] > array[mid] && array[mid] > array[mid + 1]) {
        high = mid - 1;
      } else {
        return mid;
      }
    }

    return -1;
  }
}
