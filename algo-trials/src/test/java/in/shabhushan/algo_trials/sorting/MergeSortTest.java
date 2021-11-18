package in.shabhushan.algo_trials.sorting;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter7.QuickSort.getRandomArr;
import static in.shabhushan.algo_trials.sorting.MergeSort.mergeSort;
import static junit.framework.TestCase.assertTrue;

public class MergeSortTest {
  @Test
  public void testMergeSort() {
    int[] arr = getRandomArr(10_000);

    mergeSort(arr);

    for (int i = 1; i < arr.length; i++) {
      assertTrue(arr[i] > arr[i - 1]);
    }
  }
}
