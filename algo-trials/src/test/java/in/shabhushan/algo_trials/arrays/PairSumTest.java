package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.PairSum.getPairSum;
import static org.junit.Assert.assertEquals;

public class PairSumTest {
  @Test
  public void testPairSum() {
    assertEquals(2, getPairSum(new int[]{1, 5, 7, -1}, 6));
    assertEquals(3, getPairSum(new int[]{1, 5, 7, -1, 5}, 6));
    assertEquals(6, getPairSum(new int[]{1, 1, 1, 1}, 2));
    assertEquals(9, getPairSum(new int[]{10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1}, 11));
  }
}
