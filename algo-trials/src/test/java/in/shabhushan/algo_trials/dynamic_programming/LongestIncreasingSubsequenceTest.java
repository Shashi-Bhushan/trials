package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.LongestIncreasingSubsequence.lis;
import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
  @Test
  public void testLongestIncreasingSubsequence() {
    assertEquals(13, lis(new int[]{5, 4, 11, 1, 16, 8, 4, 5, 23, 34, 45, 12, 98, 15, 14, 16, 45, 34, 67, 65, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 8767, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87, 67, 78, 72, 72, 87}));
  }
}
