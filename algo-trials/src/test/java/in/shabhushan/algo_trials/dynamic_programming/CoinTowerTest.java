package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.CoinTower.findWinner;
import static in.shabhushan.algo_trials.dynamic_programming.CoinTower.findWinnerDP;
import static org.junit.Assert.assertEquals;

public class CoinTowerTest {
  @Test
  public void testCoinTower() {
    assertEquals("Whis", findWinner(4,2, 3));
    assertEquals("Beerus", findWinner(1, 2, 3));
    assertEquals("Beerus", findWinner(10, 6, 5));
  }

  @Test
  public void testCoinTowerDP() {
    assertEquals("Whis", findWinnerDP(4,2, 3));
    assertEquals("Beerus", findWinnerDP(1, 2, 3));
    assertEquals("Beerus", findWinnerDP(10, 6, 5));
  }
}
