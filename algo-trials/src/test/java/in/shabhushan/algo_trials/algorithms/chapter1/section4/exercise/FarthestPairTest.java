package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise17FarthestPair.farthestPair;
import static org.junit.Assert.assertArrayEquals;

public class FarthestPairTest {
  @Test
  public void testFarthestPair() {
    assertArrayEquals(new double[]{-20, 50}, farthestPair(new double[]{-5.2, 9.4, 20, -10, 21.1, 40, 50, -20}), 0.0);
    assertArrayEquals(new double[]{-4, 20}, farthestPair(new double[]{-4, -3, 0, 10, 20}), 0.0);
    assertArrayEquals(new double[]{-10, 20}, farthestPair(new double[]{-10, -3, 0, 2, 4, 20}), 0.0);
  }
}
