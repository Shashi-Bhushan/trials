package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.WaysToScore.*;
import static org.junit.Assert.assertEquals;

public class WaystoScoreTest {
  @Test
  public void testGetWaysToScore() {
    assertEquals(3, getWaysToScore(11)); // 3 + 3 + 5
    assertEquals(5, getWaysToScore(13));
  }

  @Test
  public void testGetWaysToScoreDP() {
    assertEquals(3, getWaysToScoreDP(11));
    assertEquals(5, getWaysToScoreDP(13));
  }

  @Test
  public void testGetDistinctWaysToScore() {
    assertEquals(1, getDistinctWaysToScore(11, 1));
    assertEquals(2, getDistinctWaysToScore(13, 1));
  }

  @Test
  public void testGetDistinctWaysToScoreDP() {
    assertEquals(1, getDistinctWaysToScoreDP(11));
    assertEquals(2, getDistinctWaysToScoreDP(13));
  }
}
