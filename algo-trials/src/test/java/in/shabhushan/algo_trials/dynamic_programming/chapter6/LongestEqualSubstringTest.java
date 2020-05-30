package in.shabhushan.algo_trials.dynamic_programming.chapter6;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter6.LongestEqualSubstring.getLongestEqualString;
import static in.shabhushan.algo_trials.dynamic_programming.chapter6.LongestEqualSubstring.maxSubstringLengthDP;
import static org.junit.Assert.assertEquals;

public class LongestEqualSubstringTest {
  @Test
  public void testMaximumLength() {
    assertEquals(6, getLongestEqualString("142124"));
    assertEquals(4, getLongestEqualString("9430723")); // "4307" is maximum substring
  }

  @Test
  public void testMaximumLengthDP() {
    assertEquals(6, maxSubstringLengthDP("142124"));
    assertEquals(4, maxSubstringLengthDP("9430723")); // "4307" is maximum substring
  }
}
