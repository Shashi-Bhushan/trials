package in.shabhushan.cp_trials.search;

import in.shabhushan.cp_trials.math.logic.MaxSumSubarray;
import org.junit.Test;

import static in.shabhushan.cp_trials.search.MaximumSumSubarray.maximumSumSubarray;
import static in.shabhushan.cp_trials.search.MaximumSumSubarray.maximumSumSubarray2;
import static in.shabhushan.cp_trials.util.ArrayUtil.getRandomArray;
import static org.junit.Assert.assertEquals;

public class MaximumSumSubarrayTest {

  private static int[] array = getRandomArray(1000_00);

  @Test
  public void testMaximumSumSubarray() {
    assertEquals(10, maximumSumSubarray(new int[]{-1, 2 ,4 ,-3, 5, 2, -5, 2}));
    assertEquals(0, maximumSumSubarray(new int[]{}));
    assertEquals(6, maximumSumSubarray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  @Test
  public void testMaximumSumSubarray2() {
    assertEquals(10, maximumSumSubarray2(new int[]{-1, 2 ,4 ,-3, 5, 2, -5, 2}));
    assertEquals(0, maximumSumSubarray2(new int[]{}));
    assertEquals(6, maximumSumSubarray2(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }

  @Test // 3 Sec
  public void testMaximumSumSubArrayForLargeInput() {
    maximumSumSubarray(array);
  }

  @Test // 7 ms
  public void testMaximumSumSubArray2ForLargeInput() {
    maximumSumSubarray2(array);
  }
}
