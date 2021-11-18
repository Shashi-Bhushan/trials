package in.shabhushan.algo_trials.dynamic_programming.knapsack;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.knapsack.SubsetSum.subsetSum;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SubsetSumTest {
  @Test
  public void testSubsetSum() {
    assertTrue(subsetSum(new int[]{2, 3, 5, 8, 11}, 8));
    assertFalse(subsetSum(new int[]{2, 3, 5, 8, 11}, 4));
    assertTrue(subsetSum(new int[]{2, 3, 5, 8, 11}, 13)); // 8 + 5
    assertTrue(subsetSum(new int[]{2, 3, 5, 8, 11}, 19)); // 5 + 3 + 11
    assertTrue(subsetSum(new int[]{2, 3, 5, 8, 11}, 21)); // 2 + 5 + 3 + 11

    assertTrue(subsetSum(new int[]{3, 2, 7, 1}, 6));
    assertFalse(subsetSum(new int[]{3, 2, 7, 2, 5, 5}, 6));
    assertTrue(subsetSum(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8}, 10));
    assertFalse(subsetSum(new int[]{3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8, 3, 2, 7, 2, 4, 3, 4, 7, 8}, 1000));
  }
}
