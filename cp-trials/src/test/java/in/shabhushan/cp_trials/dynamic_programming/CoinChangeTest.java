package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.CoinChange.*;
import static org.junit.Assert.assertEquals;

public class CoinChangeTest {
  @Test
  public void testCoinChangeRecursiveWithMemoization() {
    assertEquals(2, minimumCoinChange(new int[]{1, 3, 4}, 6));
    assertEquals(2, minimumCoinChange(new int[]{1, 3, 4}, 7));
    assertEquals(3, minimumCoinChange(new int[]{1, 2, 5}, 11));
    assertEquals(-1, minimumCoinChange(new int[]{2}, 3));
  }

  @Test
  public void testCoinChangecoinChangeIterative() {
    assertEquals(2, coinChangeIterative(new int[]{1, 3, 4}, 6));
    assertEquals(2, coinChangeIterative(new int[]{1, 3, 4}, 7));
    assertEquals(3, coinChangeIterative(new int[]{1, 2, 5}, 11));
    assertEquals(-1, coinChangeIterative(new int[]{2}, 3));
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
    CoinChangeSolution solution2 = coinChangeIterativeWithCounting(new int[]{186, 419, 83, 408}, 6249);
    assertEquals(20, solution2.solution);
    int target2 = 6249;

    while (target2 > 0) {
      System.out.println(solution2.sequence[target2]);
      target2 -= solution2.sequence[target2];
    }
  }

  @Test
  public void testCoinChangeTotalWays() {
    assertEquals(6, totalWaysCoinChange(new int[]{1, 3, 4}, 5));
  }

  @Test
  public void testCoinChangeMinimumCoins() {
    assertEquals(3, coinChangeMinimumCoins(new int[]{1, 2, 5}, 11));
    assertEquals(-1, coinChangeMinimumCoins(new int[]{2}, 3));
    //assertEquals(20, coinChangeMinimumCoins(new int[]{186, 419, 83, 408}, 6249));
  }

  @Test
  public void testCoinChangeMinimumCoinsDP() {
    assertEquals(3, coinChangeMinimumCoinsDP(new int[]{1, 2, 5}, 11));
    assertEquals(-1, coinChangeMinimumCoinsDP(new int[]{2}, 3));
    assertEquals(20, coinChangeMinimumCoinsDP(new int[]{186, 419, 83, 408}, 6249));
  }

  @Test
  public void testChange() {
    assertEquals(4, change(new int[]{1, 2, 5}, 5));
    assertEquals(0, change(new int[]{2}, 3));
    assertEquals(1, change(new int[]{10}, 10));
  }

  @Test
  public void testChangeRecursive() {
    assertEquals(4, changeRecursive(new int[]{1, 2, 5}, 5));
    assertEquals(0, changeRecursive(new int[]{2}, 3));
    assertEquals(1, changeRecursive(new int[]{10}, 10));
  }

  @Test
  public void testNumSquares() {
    assertEquals(2, numSquares(5));
    assertEquals(3, numSquares(11));
  }

}
