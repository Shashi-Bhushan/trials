package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.CountWays.countWays;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.CountWays.countWaysDP;
import static org.junit.Assert.assertEquals;

public class CountWaysTest {
  @Test
  public void testCountWays() {
    assertEquals(3, countWays(3));
    assertEquals(5, countWays(4));
    assertEquals(8, countWays(5));
    assertEquals(13, countWays(6));
    assertEquals(21, countWays(7));
    assertEquals(34, countWays(8));
  }

  @Test
  public void testCountWaysDP() {
    assertEquals(3, countWaysDP(3));
    assertEquals(5, countWaysDP(4));
    assertEquals(8, countWaysDP(5));
    assertEquals(13, countWaysDP(6));
    assertEquals(21, countWaysDP(7));
    assertEquals(34, countWaysDP(8));
  }
}
