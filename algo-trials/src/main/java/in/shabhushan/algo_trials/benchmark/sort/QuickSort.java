package in.shabhushan.algo_trials.benchmark.sort;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.infra.Blackhole;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.function.IntSupplier;

@Warmup(iterations = 3, time = 2, timeUnit = TimeUnit.SECONDS)
@Measurement(iterations = 10, time = 2, timeUnit = TimeUnit.SECONDS)
@Fork(1)
@State(Scope.Thread)
public class QuickSort {
  private static final Random random = new Random(System.currentTimeMillis());

  private static final int ARRAY_SIZE = 100_000;

  // partition procedure (Quick sort will call this in order)
  private int partition(int[] arr, int start, int end, IntSupplier pivotIndexSupplier) {
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

  /**
   * Generate a random arr using Fisher yates shuffle
   */
  private int[] getRandomArr(int size) {
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

  public void quickSortStart(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> start;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  public void quickSortEnd(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> end;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  public void quickSortRandom(int[] arr, int start, int end) {
    IntSupplier pivotIndexSupplier = () -> random.nextInt(end - start) + start;

    if (start < end) {
      int partitionIndex = partition(arr, start, end, pivotIndexSupplier);

      quickSortStart(arr, start, partitionIndex - 1);
      quickSortStart(arr, partitionIndex + 1, end);
    }
  }

  @Benchmark
  public void testStartPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortStart(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testEndPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortEnd(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testRandomPivot(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    quickSortRandom(arr, 0, ARRAY_SIZE - 1);
  }

  @Benchmark
  public void testJavaSort(Blackhole blackhole) {
    int[] arr = getRandomArr(ARRAY_SIZE);

    // Check DualArrayPivotSort.sort method for reference
    Arrays.sort(arr);
  }

  public static void main(String[] args) {
    QuickSort s = new QuickSort();
    int[] arr = s.getRandomArr(1000);

    s.quickSortRandom(arr, 0, arr.length - 1);

    System.out.println(Arrays.toString(arr));
  }

  private void swap(int[] arr, int x, int y) {
    int temp = arr[x];
    arr[x] = arr[y];
    arr[y] = temp;
  }
}
