package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.WaysToScore.getWaysToScore;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.WaysToScore.getWaysToScoreIterative;
import static org.junit.Assert.assertEquals;

public class WaystoScoreTest {
  @Test
  public void testGetWaysToScore() {
    assertEquals(5, getWaysToScore(13));
  }

  @Test
  public void testGetWaysToScoreDP() {
    assertEquals(5, getWaysToScoreIterative(13));
  }
}
