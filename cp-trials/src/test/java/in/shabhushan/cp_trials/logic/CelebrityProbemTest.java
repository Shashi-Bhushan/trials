package in.shabhushan.cp_trials.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.logic.CelebrityProblem.findJudge;
import static in.shabhushan.cp_trials.logic.CelebrityProblem.findJudge2;
import static org.junit.Assert.assertEquals;

public class CelebrityProbemTest {
  @Test
  public void testCelebrityProblem() {
    assertEquals(-1, findJudge(11, new int[][]{
        new int[]{1, 8},
        new int[]{1, 3},
        new int[]{2, 8},
        new int[]{2, 3},
        new int[]{4, 8},
        new int[]{4, 3},
        new int[]{5, 8},
        new int[]{5, 3},
        new int[]{6, 8},
        new int[]{6, 3},
        new int[]{7, 8},
        new int[]{7, 3},
        new int[]{9, 8},
        new int[]{9, 3},
        new int[]{11, 8},
        new int[]{11, 3}
    }));
  }

  @Test
  public void testCelebrityProblem2() {
    assertEquals(-1, findJudge2(11, new int[][]{
        new int[]{1, 8},
        new int[]{1, 3},
        new int[]{2, 8},
        new int[]{2, 3},
        new int[]{4, 8},
        new int[]{4, 3},
        new int[]{5, 8},
        new int[]{5, 3},
        new int[]{6, 8},
        new int[]{6, 3},
        new int[]{7, 8},
        new int[]{7, 3},
        new int[]{9, 8},
        new int[]{9, 3},
        new int[]{11, 8},
        new int[]{11, 3}
    }));
  }
}
