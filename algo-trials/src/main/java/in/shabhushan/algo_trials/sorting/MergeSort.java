package in.shabhushan.algo_trials.sorting;

public class MergeSort {
  public static void mergeSort(int[] input) {
    mergeSort(input, 0, input.length - 1);
  }

  private static void mergeSort(int[] input, int start, int end) {
    if (start < end) {
      int mid = start + (end - start) / 2;

      mergeSort(input, start, mid);
      mergeSort(input, mid + 1, end);

      merge(input, start, mid, end);
    }
  }

  private static void merge(int[] input, int start, int mid, int end) {
    // mid included here
    int n1 = mid - start + 1;
    // mid excluded here
    int n2 = end - mid;

    int[] left = new int[n1 + 1];
    int[] right = new int[n2 + 1];

    // copy input in left & right
    for (int i = 0; i < n1; i++) {
      left[i] = input[start + i];
    }
    // System.arraycopy(input, start + 0, left, 0, n1);

    for (int j = 0; j < n2; j++) {
      right[j] = input[(mid + 1) + j];
    }
    // System.arraycopy(input, (mid + 1), right, 0, n2);

    // Sentinel value
    left[n1] = Integer.MAX_VALUE;
    right[n2] = Integer.MAX_VALUE;

    // merge from start to end in input now
    int x = 0;
    int y = 0;

    for (int i = start; i <= end; i++) {
      if (left[x] < right[y]) {
        input[i] = left[x++];
      } else {
        input[i] = right[y++];
      }
    }
  }
}
