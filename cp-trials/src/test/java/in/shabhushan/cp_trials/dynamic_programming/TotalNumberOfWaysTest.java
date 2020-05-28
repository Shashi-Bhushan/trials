package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.TotalNumberOfWays.totalWays;
import static org.junit.Assert.assertEquals;

public class TotalNumberOfWaysTest {
  @Test
  public void testTotalNumberOfWays() {
    assertEquals(6, totalWays(3));
    assertEquals(20, totalWays(4));
  }
}
