package in.shabhushan.algo_trials.clrs.chapter15;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter15.LongestCommonSubsequence.getLongestCommonSubsequence;
import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
  @Test
  public void testCommonSubsequence() {
    assertEquals("BCBA", getLongestCommonSubsequence("ABCBDAB", "BDCABA"));
  }
}
