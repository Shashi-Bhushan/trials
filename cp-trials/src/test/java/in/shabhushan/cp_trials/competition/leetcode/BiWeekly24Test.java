package in.shabhushan.cp_trials.competition.leetcode;

import org.junit.Test;

import static in.shabhushan.cp_trials.competition.leetcode.BiWeekly24.findMinFibonacciNumbers;
import static org.junit.Assert.assertEquals;

public class BiWeekly24Test {
  @Test
  public void testMinFib() {
    assertEquals(2, findMinFibonacciNumbers(7));
  }
}
