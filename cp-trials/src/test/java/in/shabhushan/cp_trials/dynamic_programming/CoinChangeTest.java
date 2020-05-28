package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.dynamic_programming.CoinChange.*;
import static org.junit.Assert.assertEquals;

public class CoinChangeTest {
  @Test
  public void testCoinChangeRecursiveWithMemoization() {
    assertEquals(2, coinChangeRecursiveWithMemoization(new int[]{1, 3, 4}, 6));
  }

  @Test
  public void testCoinChangecoinChangeIterative() {
    assertEquals(2, coinChangeIterative(new int[]{1, 3, 4}, 6));
  }

  @Test
  public void testCoinChangeWithSequence() {
    CoinChangeSolution solution = coinChangeIterativeWithCounting(new int[]{1, 3, 4}, 6);
    assertEquals(2, solution.solution);
    int target = 6;

    while (target > 0) {
      System.out.println(solution.sequence[target]);
      target -= solution.sequence[target];
    }
  }

  @Test
  public void testCoinChangeTotalWays() {
    assertEquals(6, totalWaysCoinChange(new int[]{1, 3, 4}, 5));
  }

}
