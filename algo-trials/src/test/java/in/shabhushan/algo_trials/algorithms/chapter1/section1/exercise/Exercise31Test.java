package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise31.createCoprimeArray;
import static org.junit.Assert.assertArrayEquals;

public class Exercise31Test {
  @Test
  public void testCoPrime() {
    boolean[][] coprimeArray = createCoprimeArray(5);

    boolean[][] expected = {
        new boolean[]{false, true, true, true, true},
        new boolean[]{true, true, true, true, true},
        new boolean[]{true, true, false, true, false},
        new boolean[]{true, true, true, false, true},
        new boolean[]{true, true, false, true, false}
    };
    assertArrayEquals(expected, coprimeArray);
  }
}
