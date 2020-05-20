package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.util.ArrayUtil.getRandomArray;
import static org.junit.Assert.assertEquals;

public class MaxSumSubarrayTest {

  @Test
  public void testEmptyArray() throws Exception {
    assertEquals("Empty arrays should have a max of 0", 0, MaxSumSubarray.sequence(new int[]{}));
  }

  @Test
  public void testExampleArray() throws Exception {
    assertEquals("Example array should have a max of 6", 6, MaxSumSubarray.sequence(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
  }
}
