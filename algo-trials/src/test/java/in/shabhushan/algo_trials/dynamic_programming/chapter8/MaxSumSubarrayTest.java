package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Ignore;
import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.MaxSumSubarray.maxSumSubarray;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.MaxSumSubarray.maxSumSubarrayDP;
import static org.junit.Assert.assertEquals;

public class MaxSumSubarrayTest {
  @Test
  @Ignore
  public void testSumSubArray() {
    assertEquals(7, maxSumSubarray(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
  }

  @Test
  public void testSumSubArrayDP() {
    assertEquals(7, maxSumSubarrayDP(new int[]{-2, -3, 4, -1, -2, 1, 5, -3}));
  }
}
