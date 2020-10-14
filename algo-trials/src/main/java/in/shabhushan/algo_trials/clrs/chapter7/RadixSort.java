package in.shabhushan.algo_trials.clrs.chapter7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

  /**
   * Java method to sort a given array using radix sort algorithm
   *
   * @param input
   */
  public static void radixSortUsingList(int[] input) {
    final int RADIX = 10;

    // declare and initialize bucket[]
    List<Integer>[] bucket = new ArrayList[RADIX];

    for (int i = 0; i < bucket.length; i++) {
      bucket[i] = new ArrayList<>();
    }

    // sort
    boolean maxLength = false;
    int tmp = -1, placement = 1;
    while (!maxLength) {
      maxLength = true;

      // split input between lists
      for (Integer i : input) {
        tmp = i / placement;
        bucket[tmp % RADIX].add(i);
        if (maxLength && tmp > 0) {
          maxLength = false;
        }
      }

      // empty lists into input array
      int a = 0;
      for (int b = 0; b < RADIX; b++) {
        for (Integer i : bucket[b]) {
          input[a++] = i;
        }
        bucket[b].clear();
      }

      // move to next digit
      placement *= RADIX;
    }
  }
}
