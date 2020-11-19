package in.shabhushan.algo_trials.clrs.chapter6;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter6.InplaceHeapSort.inplaceHeapSort;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class InplaceHeapSortTest {
  @Test
  public void testInPlaceHeapSort() {
    int[] arr = {2, 6, 8, 5, 4, 3, 10};

    inplaceHeapSort(arr);

    assertArrayEquals(new int[]{10, 8, 6, 5, 4, 3, 2}, arr);
  }
}
