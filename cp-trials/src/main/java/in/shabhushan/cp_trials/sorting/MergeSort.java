package in.shabhushan.cp_trials.sorting;

import java.util.Arrays;

import static in.shabhushan.cp_trials.search.KthLargestElement.swap;

public class MergeSort {
  public static int[] mergeSort(int[] array) {
    return sortHelper(array);
  }

  /**
   * Left and right both are inclusive
   */
  private static int[] sortHelper(int[] array) {
    if (array.length == 2) {
      if (array[0] > array[1]) {
        int[] newArray = Arrays.copyOf(array, array.length);
        swap(newArray, 0, 1);
        return newArray;
      } else {
        return array;
      }
    } else if (array.length == 1) {
      return array;
    } else {
      int mid = (array.length - 1) / 2;

      int[] leftArray = sortHelper(Arrays.copyOfRange(array, 0, mid + 1));
      int[] rightArray = sortHelper(Arrays.copyOfRange(array, mid + 1, array.length));

      return mergeHelper(leftArray, rightArray);
    }
  }

  /**
   * Merge the array from left to right together
   * Need to merge the 2 sorted array parts' in correct order
   */
  private static int[] mergeHelper(int[] leftArray, int[] rightArray) {
    int i = 0;
    int j = 0;
    int k = 0;

    int[] result = new int[leftArray.length + rightArray.length];

    while (i < leftArray.length && j < rightArray.length) {
      if (leftArray[i] < rightArray[j]) {
        result[k++] = leftArray[i++];
      } else {
        result[k++] = rightArray[j++];
      }
    }

    while (i < leftArray.length) {
      result[k++] = leftArray[i++];
    }

    while (j < rightArray.length) {
      result[k++] = rightArray[j++];
    }

    return result;
  }
}
