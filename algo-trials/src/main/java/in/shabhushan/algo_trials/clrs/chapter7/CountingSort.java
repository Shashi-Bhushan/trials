package in.shabhushan.algo_trials.clrs.chapter7;

public class CountingSort {
  public static int[] stableCountingSort(int[] arr, int range) {
    return stableCountingSort(arr, 0, range);
  }

  public static int[] stableCountingSort(int[] arr, int rangeStartInclusive, int rangeStopExclusive) {
    int[] freq = new int[rangeStopExclusive - rangeStartInclusive + 1];

    int[] output = new int[arr.length];
    System.arraycopy(arr, 0, output, 0, arr.length);

    for (int num: arr) {
      freq[num - rangeStartInclusive]++;
    }

    for (int i = 1; i < freq.length; i++) {
      freq[i] += freq[i - 1];
    }

    for (int i = arr.length - 1; i >= 0; i--) {
      int input = arr[i];

      output[freq[input - rangeStartInclusive] - 1] = input;
      freq[input - rangeStartInclusive]--;
    }

    return output;
  }

  public static int[] unstableCountingSort(int[] arr, int range) {
    return unstableCountingSort(arr, 0, range);
  }

  public static int[] unstableCountingSort(int[] arr, int rangeStartInclusive, int rangeStopExclusive) {
    int[] freq = new int[rangeStopExclusive - rangeStartInclusive + 1];

    for (int num: arr) {
      freq[num - rangeStartInclusive]++;
    }

    int[] output = new int[arr.length];

    for (int i = 0; i < arr.length; i++) {
      // - 1 since counting is one based and index is zero based
      for (int j = 0; j < freq[i]; j++) {
        output[i] = i + rangeStartInclusive;
      }
    }

    return output;
  }
}
