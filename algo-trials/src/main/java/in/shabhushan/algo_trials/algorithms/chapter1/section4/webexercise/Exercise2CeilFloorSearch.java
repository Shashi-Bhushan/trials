package in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise;

/**
 * Given a set of comparable elements, the ceiling of x is the smallest element in the set greater than or equal to x, and the floor is the largest element less than or equal to x.
 * Suppose you have an array of N items in ascending order. Give an O(log N) algorithm to find the floor and ceiling of x.
 */
public class Exercise2CeilFloorSearch {
  public static int[] getFloorCeil(int[] array, int x) {
    return new int[]{
        getFloor(array, x),
        getCeil(array, x)
    };
  }

  private static int getFloor(int[] array, int x) {
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      // if x is greater than high, than high is floor for this.
      if (array[high] <= x)
        return array[high];
      else if (x < array[low])
        // if x is less than low, you won't find it in whole array
        return -1;

      int mid = low + (high - low) / 2;

      // if x is mid, return it
      if (array[mid] == x)
        return array[mid];
      else if (array[mid] < x) {
        // Searching in right side now

        // if array[mid] < x <= array[mid + 1], mid is floor for x
        if (mid + 1 <= high && x <= array[mid + 1])
          return array[mid];
        else
          low = mid + 1;
      } else {
        // if array[mid - 1] <= x < array[mid], mid - 1 is floor for x
        if (low <= mid - 1 && array[mid - 1] <= x)
          return array[mid - 1];
        else
          high = mid - 1;
      }
    }

    return -1;
  }

  private static int getCeil(int[] array, int x) {
    int low = 0;
    int high = array.length - 1;

    while (low <= high) {
      // if x is less than low, consider low as ceil for x
      if (x <= array[low])
        return array[low];
      else if (array[high] < x)
        // if x is more than high, ceil won't be there in array
        return -1;

      int mid = low + (high - low) / 2;

      if (array[mid] == x)
        return array[mid];
      else if (array[mid] < x) {
        // Searching in right side

        // if array[mid] < x <= array[mid + 1], consider mid + 1 as ceil for x
        if (mid + 1 <= high && x <= array[mid + 1])
          return array[mid + 1];
        else
          low = mid + 1;
      } else {
        // Searching in left now

        // if array[mid - 1] <= x < array[mid], consider mid as ceil for x
        if (low <= mid - 1 && array[mid - 1] <= x)
          return array[mid];
        else
          high = mid - 1;
      }
    }

    return -1;
  }
}
