package in.shabhushan.cp_trials.contest;

import org.junit.Test;

import static in.shabhushan.cp_trials.contest.Weekly186.maxScore;
import static org.junit.Assert.assertEquals;

public class Weekly186Test {
  @Test
  public void testMaxScore() {
    assertEquals(12, maxScore(new int[]{1, 2, 3, 4, 5, 6, 1}, 3));
    assertEquals(4, maxScore(new int[]{2, 2, 2}, 2));
    assertEquals(55, maxScore(new int[]{9, 7, 7, 9, 7, 7, 9}, 7));
    assertEquals(1, maxScore(new int[]{1, 1000, 1}, 1));
    assertEquals(202, maxScore(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3));
    assertEquals(5279, maxScore(new int[]{99, 82, 25, 56, 39, 77, 22, 58, 64, 77, 19, 36, 93, 14, 19, 12, 94, 76, 93, 24, 92, 67, 18, 37, 37, 60, 87, 28, 64, 7, 29, 36, 456, 789, 883, 67, 34, 1, 0, 101, 209, 345, 345, 456, 675, 0, 1, 23, 12, 11, 22}, 35));
  }
}
