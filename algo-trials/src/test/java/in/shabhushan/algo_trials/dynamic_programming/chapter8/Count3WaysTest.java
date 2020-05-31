package in.shabhushan.algo_trials.dynamic_programming.chapter8;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter8.Count3Ways.count3Ways;
import static in.shabhushan.algo_trials.dynamic_programming.chapter8.Count3Ways.count3WaysIterative;
import static org.junit.Assert.assertEquals;

public class Count3WaysTest {
  @Test
  public void testCount3Ways() {
    assertEquals(1, count3Ways(0));
    assertEquals(0, count3Ways(1));
    assertEquals(3, count3Ways(2));
    assertEquals(153, count3Ways(8));
    assertEquals(2131, count3Ways(12));
    assertEquals(299303201, count3Ways(30));
    assertEquals(0, count3Ways(-1));
  }

  @Test
  public void testCount3WaysIterative() {
    assertEquals(1, count3WaysIterative(0));
    assertEquals(0, count3WaysIterative(1));
    assertEquals(3, count3WaysIterative(2));
    assertEquals(153, count3WaysIterative(8));
    assertEquals(2131, count3WaysIterative(12));
    assertEquals(299303201, count3WaysIterative(30));
    assertEquals(0, count3WaysIterative(-1));
  }
}
