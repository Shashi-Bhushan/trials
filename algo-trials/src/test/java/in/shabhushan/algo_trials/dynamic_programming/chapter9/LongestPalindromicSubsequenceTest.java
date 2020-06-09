package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.LongestPalindromicSubsequence.lps;
import static in.shabhushan.algo_trials.dynamic_programming.chapter9.LongestPalindromicSubsequence.lpsDP;
import static org.junit.Assert.assertEquals;

public class LongestPalindromicSubsequenceTest {
  @Test
  public void testLps() {
    assertEquals(3, lps("ABECA"));
    assertEquals(7, lps("BBABCBCAB"));
  }

  @Test
  public void testLpsDP() {
    assertEquals(3, lpsDP("ABECA"));
    assertEquals(7, lpsDP("BBABCBCAB"));
  }
}
