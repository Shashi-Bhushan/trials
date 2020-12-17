package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.Knapsack.*;
import static org.junit.Assert.assertEquals;

public class KnapsackTest {
  @Test
  public void testKnapsack() {
    assertEquals(260, knapsack(new int[]{60, 100, 120, 50, 100, 3, 20, 30, 100, 3, 80, 30}, new int[]{10, 20, 30, 20, 20, 50, 40, 10, 30, 20, 25, 50}, 50));
    assertEquals(40, knapsack(new int[]{1, 6, 18, 22, 28}, new int[]{1, 2, 5, 6, 7}, 11));
    assertEquals(7, knapsack(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 5));
  }

  @Test
  public void testKnapsackDP() {
    assertEquals(220, knapsackDP(new int[]{60, 100, 120}, new int[]{10, 20, 30}, 50));
    assertEquals(40, knapsackDP(new int[]{1, 6, 18, 22, 28}, new int[]{1, 2, 5, 6, 7}, 11));
    assertEquals(7, knapsackDP(new int[]{3, 4, 5, 6}, new int[]{2, 3, 4, 5}, 5));
  }
}
