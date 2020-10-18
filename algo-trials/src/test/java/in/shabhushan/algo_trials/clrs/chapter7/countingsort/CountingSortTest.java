package in.shabhushan.algo_trials.clrs.chapter7.countingsort;

import org.junit.Test;

import java.util.Arrays;

import static in.shabhushan.algo_trials.clrs.chapter7.CountingSort.stableCountingSort;
import static in.shabhushan.algo_trials.clrs.chapter7.CountingSort.unstableCountingSort;
import static org.junit.Assert.assertArrayEquals;

public class CountingSortTest {
  @Test
  public void testStableCountingSort() {
    int[] arr = {1, 4, 2, 5, 3, 6, 7, 0, 8};

    assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, stableCountingSort(arr, 8));

    int[] secondArray = Arrays.stream(arr).map(i -> i + 15).toArray();

    assertArrayEquals(new int[]{15, 16, 17, 18, 19, 20, 21, 22, 23}, stableCountingSort(secondArray, 15, 23));
  }

  @Test
  public void testUnstableCountingSort() {
    int[] arr = {1, 4, 2, 5, 3, 6, 7, 0, 8};

    assertArrayEquals(new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8}, unstableCountingSort(arr, 8));

    int[] secondArray = Arrays.stream(arr).map(i -> i + 15).toArray();

    assertArrayEquals(new int[]{15, 16, 17, 18, 19, 20, 21, 22, 23}, unstableCountingSort(secondArray, 15, 23));
  }
}
