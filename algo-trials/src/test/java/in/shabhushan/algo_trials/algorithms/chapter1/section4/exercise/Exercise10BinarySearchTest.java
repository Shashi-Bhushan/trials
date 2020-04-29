package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise10BinarySearch.binarySearchFirstIndex;
import static org.junit.Assert.assertEquals;

public class Exercise10BinarySearchTest {
  @Test
  public void testBinarySearchFirstIndex() {
    assertEquals(1, binarySearchFirstIndex(new int[]{3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21}, 4));
    assertEquals(7, binarySearchFirstIndex(new int[]{3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21}, 20));
    assertEquals(-1, binarySearchFirstIndex(new int[]{3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21}, -5));
    assertEquals(0, binarySearchFirstIndex(new int[]{4, 4, 4, 4, 4, 4, 15, 20, 20, 20, 20, 21}, 4));
  }
}
