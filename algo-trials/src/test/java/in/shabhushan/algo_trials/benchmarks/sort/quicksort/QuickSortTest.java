package in.shabhushan.algo_trials.benchmarks.sort.quicksort;

import org.junit.Test;

import static in.shabhushan.algo_trials.benchmark.sort.quicksort.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.benchmark.sort.quicksort.QuickSort.quickSortRandom;
import static junit.framework.TestCase.assertTrue;

public class QuickSortTest {
  @Test
  public void testQuickSort() {
    int[] arr = getRandomArr(10_000);

    quickSortRandom(arr, 0, arr.length - 1);

    for (int i = 1; i < arr.length; i++) {
      assertTrue(arr[i] > arr[i - 1]);
    }
  }

}
