package in.shabhushan.cp_trials.contest;

import org.junit.Test;

import static in.shabhushan.cp_trials.contest.BiWeekly24.findMinFibonacciNumbers;
import static org.junit.Assert.assertEquals;

public class BiWeekly24Test {
  @Test
  public void testMinFib() {
    assertEquals(2, findMinFibonacciNumbers(7));
  }
}
