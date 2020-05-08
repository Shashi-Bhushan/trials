package in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section1.exercise.Exercise29.lessThan;
import static org.junit.Assert.assertEquals;

public class Exercise29Test {
  @Test
  public void testLessThan() {
    int[] array = {1, 2, 4, 4, 5, 6, 6, 7, 7, 7, 8};

    assertEquals(2, lessThan(3, array));
    assertEquals(4, lessThan(4, array));
  }
}
