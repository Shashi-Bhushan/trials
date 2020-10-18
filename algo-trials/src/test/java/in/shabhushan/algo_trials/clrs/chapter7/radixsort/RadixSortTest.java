package in.shabhushan.algo_trials.clrs.chapter7.radixsort;

import org.junit.Test;

import java.util.Arrays;

import static in.shabhushan.algo_trials.clrs.chapter7.RadixSort.radixSort;
import static org.junit.Assert.assertArrayEquals;

public class RadixSortTest {
  @Test
  public void testRadixSort() {
    int[] arr = {1, 4, 2, 5, 3, 6, 7, 0, 8};

    assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, radixSort(arr));

    int[] secondArray = Arrays.stream(arr).map(i -> i + 15).toArray();
    secondArray[2] = 62345;

    assertArrayEquals(new int[]{15, 16, 18, 19, 20, 21, 22, 23, 62345}, radixSort(secondArray));
  }
}
