package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.SubsetSum.subsetSum;
import static in.shabhushan.algo_trials.dynamic_programming.chapter9.SubsetSum.subsetSumDP;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubsetSumTest {
  @Test
  public void testSubsetSum() {
    assertTrue(subsetSum(new int[]{3, 2, 7, 1}, 6));
    assertFalse(subsetSum(new int[]{3, 2, 7, 2, 5, 5}, 6));
    assertTrue(subsetSum(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8}, 10));
    assertFalse(subsetSum(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8}, 1000));
  }

  @Test
  public void testSubsetSumDP() {
    assertTrue(subsetSumDP(new int[]{3, 2, 7, 1}, 6));
    assertFalse(subsetSumDP(new int[]{3, 2, 7, 2, 5, 5}, 6));
    assertTrue(subsetSumDP(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8}, 10));
    assertFalse(subsetSumDP(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8}, 1000));
  }
}
