package in.shabhushan.cp_trials.sorting;

import static in.shabhushan.cp_trials.search.KthLargestElement.swap;

public class QuickSort {
  public static void quickSort(int[] array) {
    helper(array, 0, array.length - 1);
  }

  private static void helper(int[] array, int left, int right) {
    if (left <= right) {
      // swap left and right
      swap(array, left, right);

      // after swap, pivot is on right
      int pivot = array[right];

      int leftTail = left;
      for (int i = left; i < right; i++) {
        if (array[i] < pivot) {
          swap(array, i, leftTail);
          leftTail++;
        }
      }

      swap(array, leftTail, right);

      // sort left half
      helper(array, left, leftTail - 1);

      // sort right half
      helper(array, leftTail + 1, right);
    }
  }
}
