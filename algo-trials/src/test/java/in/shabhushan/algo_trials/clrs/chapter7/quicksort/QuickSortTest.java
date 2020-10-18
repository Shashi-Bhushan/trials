package in.shabhushan.algo_trials.clrs.chapter7.quicksort;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.*;
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

  @Test
  public void testQuickSort2() {
    int[] arr = new int[]{
      8, 9, 7, 9, 6, 5, 8, 5, 2, 2, 1, 0, 10
    };

    quickSortEquals(arr, 0, arr.length - 1);

    System.out.println(arr);
  }

}
