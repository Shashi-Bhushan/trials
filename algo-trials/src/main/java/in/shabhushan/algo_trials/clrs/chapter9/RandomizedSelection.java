package in.shabhushan.algo_trials.clrs.chapter9;

import java.util.Arrays;
import java.util.Random;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.swap;

public class RandomizedSelection {
  private static final Random random = new Random(System.currentTimeMillis());

  // quick sort's partition procedure
  private static int randomizedPartition(int[] arr, int start, int end) {
    int pivotIndex = random.nextInt(end - start) + start;

    swap(arr, end, pivotIndex);
    int pivot = arr[end];

    int j = start;

    for (int i = start; i < end; i++) {
      if (arr[i] < pivot) {
        swap(arr, i, j);
        j++;
      }
    }

    swap(arr, j, end);
    return j;
  }

  public static int randomSelection(int[] arr, int key) {
    return randomSelection(arr, 0, arr.length - 1, key);
  }

  /**
   * Finds what's the value at index ${key} in the sorted arr array without actually sorting it
   * start, end and key is also 0 based
   */
  public static int randomSelection(int[] arr, int start, int end, int key) {
    if (start == end)
      return arr[start];

    int mid = randomizedPartition(arr, start, end);

    // size of array at left + 1 for pivot
    int leftSize = (mid - start) + 1;

    // System.out.println(Arrays.toString(arr));
    // System.out.println("leftSize " + leftSize + ", key " + key + ", start " + start + ", mid " + mid + ", end " + end);
    if (leftSize == key + 1) {
      return arr[mid];
    }
    else if (key + 1 < leftSize) {
      return randomSelection(arr, start, mid - 1, key);
    } else {
      return randomSelection(arr, mid + 1, end, key - leftSize);
    }
  }

  public static int randomSelectionIter(int[] arr, int start, int end, int key) {
    while (start != end) {
      int mid = randomizedPartition(arr, start, end);

      int leftSize = (mid - start) + 1;

      // System.out.println(Arrays.toString(arr));
      // System.out.println("leftSize " + leftSize + ", key " + key + ", start " + start + ", mid " + mid + ", end " + end);

      // compare zero based key with one based leftSize
      if (leftSize == key + 1) {
        return arr[mid];
      } else if (key + 1 < leftSize) {
        end = mid - 1;
      } else {
        start = mid + 1;
        key = key - leftSize;
      }
    }

    return arr[start];
  }
}
