package in.shabhushan.cp_trials.array;

import org.junit.Test;

import static in.shabhushan.cp_trials.array.ArraySumTarget.numSubmatrixSumTarget;
import static org.junit.Assert.assertEquals;

public class ArraySumTargetSolution {
  @Test
  public void testArraySumTarget() {
    assertEquals(43, numSubmatrixSumTarget(new int[][]{
        new int[]{0, 1, 1, 1, 0, 1},
        new int[]{0, 0, 0, 0, 0, 1},
        new int[]{0, 0, 1, 0, 0, 1},
        new int[]{1, 1, 0, 1, 1, 0},
        new int[]{1, 0, 0, 1, 0, 0}
    }, 0));
  }
}
