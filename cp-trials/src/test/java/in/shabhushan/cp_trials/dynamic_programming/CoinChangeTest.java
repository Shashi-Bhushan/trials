package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.CoinChange.coinChangeIterative;
import static in.shabhushan.cp_trials.dynamic_programming.CoinChange.coinChangeRecursiveWithMemoization;
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
}
