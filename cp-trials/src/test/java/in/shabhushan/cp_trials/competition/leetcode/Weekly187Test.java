package in.shabhushan.cp_trials.competition.leetcode;

import org.junit.Test;

import static in.shabhushan.cp_trials.competition.leetcode.Weekly187.kthSmallest;
import static in.shabhushan.cp_trials.competition.leetcode.Weekly187.longestSubarray;
import static org.junit.Assert.assertEquals;

public class Weekly187Test {
  @Test
  public void testLongestSubArray() {
    assertEquals(2, longestSubarray(new int[]{8, 2, 4, 7}, 4));
    assertEquals(4, longestSubarray(new int[]{10, 1, 2, 4, 7, 2}, 5));
    assertEquals(3, longestSubarray(new int[]{4, 2, 2, 2, 4, 4, 2, 2}, 0));
    assertEquals(3, longestSubarray(new int[]{4, 8, 5, 1, 7, 9}, 6));
  }

  @Test
  public void testKthSmallest() {
    assertEquals(7, kthSmallest(new int[][]{
        {1, 3, 11},
        {2, 4, 6}
    }, 5));
    assertEquals(17, kthSmallest(new int[][]{
        {1, 3, 11},
        {2, 4, 6}
    }, 9));
    assertEquals(9, kthSmallest(new int[][]{
        {1, 10, 10},
        {1, 4, 5},
        {2, 3, 6}
    }, 7));
    assertEquals(12, kthSmallest(new int[][]{
        {1, 1, 10},
        {2, 2, 9}
    }, 7));
    assertEquals(75, kthSmallest(new int[][]{
        {6, 9, 32, 34, 43, 45},
        {5, 10, 18, 21, 40, 42},
        {15, 16, 22, 33, 50, 50},
        {14, 27, 29, 31, 33, 39},
        {1, 11, 19, 25, 45, 50},
        {3, 9, 17, 19, 26, 30},
        {3, 14, 26, 29, 41, 43},
        {12, 23, 25, 26, 40, 46}
    }, 47));
  }
}
