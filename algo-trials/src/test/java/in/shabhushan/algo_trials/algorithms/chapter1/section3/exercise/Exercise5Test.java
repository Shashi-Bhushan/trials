package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise.Exercise5.getBinaryRepresentation;
import static org.junit.Assert.assertArrayEquals;

public class Exercise5Test {
  @Test
  public void testBinaryArray() {
    assertArrayEquals(new int[]{1, 1}, getBinaryRepresentation(3));
    assertArrayEquals(new int[]{1, 1, 0}, getBinaryRepresentation(6));
  }
}
