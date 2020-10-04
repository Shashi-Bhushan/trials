package in.shabhushan.algo_trials.benchmark.sort.radixsort;

import java.util.Arrays;

public class RadixSort {
  public static int[] radixSort(int[] input) {
    return radixSort(input, 9);
  }

  public static int[] radixSort(int[] input, int radix) {
    int[] inputCopy = new int[input.length];
    System.arraycopy(input, 0, inputCopy, 0, input.length);

    int[] output = new int[input.length];
    int[] prefixSum = new int[256];

    for (int i = radix; i >= 0; i--) {
      // radix for 0-9
      for (int j = 0; j < 256; j++) {
        prefixSum[j] = 0;
      }

      for (int num: inputCopy) {
        prefixSum[(num >> i) & 0xff]++;
      }

      for (int j = 1; j < 256; j++) {
        prefixSum[j] += prefixSum[j - 1];
      }

      for (int num: inputCopy) {
        int index = (num >> i) & 0xff;

        output[(prefixSum[index] - 1)] = num;
        prefixSum[index]--;
      }

      inputCopy = Arrays.copyOf(output, output.length);
    }

    return inputCopy;
  }

  private static int getMax(int[] arr) {
    int max = arr[0];

    for (int i = 1; i < arr.length; i++) {
      max = Math.max(max, arr[i]);
    }

    return max;
  }
}
