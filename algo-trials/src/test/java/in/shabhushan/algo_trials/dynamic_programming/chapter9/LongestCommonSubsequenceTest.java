package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.LongestCommonSubsequence.longestCommonSubsequenceLength;
import static in.shabhushan.algo_trials.dynamic_programming.chapter9.LongestCommonSubsequence.longestCommonSubsequenceLengthDP;
import static org.junit.Assert.assertEquals;

public class LongestCommonSubsequenceTest {
  @Test
  public void testLongestCommonSubsequence() {
    assertEquals(3, longestCommonSubsequenceLength("ABCD", "AEBD"));
    //assertEquals(14, longestCommonSubsequenceLength("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC"));
  }

  @Test
  public void testLongestCommonSubsequenceDP() {
    assertEquals(3, longestCommonSubsequenceLengthDP("ABCD", "AEBD"));
    assertEquals(14, longestCommonSubsequenceLengthDP("AAACCGTGAGTTATTCGTTCTAGAA", "CACCCCTAAGGTACCTTTGGTTC"));
  }
}
