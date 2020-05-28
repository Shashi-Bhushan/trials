package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.LongestIncreasingSubsequence.lengthOfLIS;
import static org.junit.Assert.assertEquals;

public class LongestIncreasingSubsequenceTest {
  @Test
  public void testLongestIncreasingSubsequenceTest() {
    assertEquals(4, lengthOfLIS(new int[]{10,9,2,5,3,7,101,18}));
  }
}
