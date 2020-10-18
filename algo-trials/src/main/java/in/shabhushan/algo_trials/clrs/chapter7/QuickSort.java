package in.shabhushan.algo_trials.clrs.chapter7;

import java.util.Arrays;
import java.util.Map;
import java.util.Random;
import java.util.function.IntSupplier;


public class QuickSort {
  private static final Random random = new Random(System.currentTimeMillis());

  public static final int ARRAY_SIZE = 100_000;

  // partition procedure (Quick sort will call this in order)
  private static int partition(int[] arr, int start, int end, IntSupplier pivotIndexSupplier) {
    int pivotIndex = pivotIndexSupplier.getAsInt();

    swap(arr, pivotIndex, end);
    int pivot = arr[end];

    int j = start;

    for (int i = start; i < end; i++) {
      if (arr[i] <= pivot) {
        swap(arr, i, j);
        j++;
      }
    }

    swap(arr, j, end);
    return j;
  }

  private static Map.Entry<Integer, Integer> partitionEquals(int[] arr, int start, int end) {
    swap(arr, start, end);
    int pivot = arr[end];

    int i = start - 1;
    int k = start;

    for (int j = start; j < end; j++) {
      if (arr[j] < pivot) {
        i++;
        k++;
        int val = arr[k];
        arr[k] = arr[i];
        arr[i] = arr[j];
        arr[j] = val;
      } else if (arr[j] == pivot) {
        k = k + 1;
        swap(arr, k, j);
      }
    }

    swap(arr, k, end);
    return Map.entry(i + 1, k + 1);
  }

  /**
   * Generate a random arr using Fisher yates shuffle
   */
  public static int[] getRandomArr(int size) {
    int[] arr = new int[size];

    for (int i = 0; i < size; i++) {
      arr[i] = i;
    }

    // Fisher yates shuffle
    for (int i = size; i > 0; i--) {
      int index = random.nextInt(i);

      swap(arr, index, i - 1);
    }

    return arr;
  }

  public static void quickSortEquals(int[] arr, int start, int end) {
    if (start < end) {
      Map.Entry<Integer, Integer> partitionIndex = partitionEquals(arr, start, end);

      quickSortEquals(arr, start, partitionIndex.getKey() - 1);
      quickSortEquals(arr, partitionIndex.getValue() + 1, end);
    }
  }

  public static void quickSortStart(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> start;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  public static void quickSortEnd(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> end;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  public static void quickSortRandom(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> random.nextInt(end - start) + start;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  public static void main(String[] args) {
    int[] arr = getRandomArr(1000);

    quickSortRandom(arr, 0, arr.length - 1);

    System.out.println(Arrays.toString(arr));
  }

  public static void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}
