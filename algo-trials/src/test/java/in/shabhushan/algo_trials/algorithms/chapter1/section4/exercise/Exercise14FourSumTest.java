package in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.exercise.Exercise14FourSum.fourSum;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Exercise14FourSumTest {
  @Test
  public void testFourSum() {
    List<int[]> answer = fourSum(new int[]{5, 2, -2, -5, -2});

    assertEquals(2, answer.size());
    assertArrayEquals(new int[]{5, 2, -2, -5}, answer.get(0));
    assertArrayEquals(new int[]{5, 2, -5, -2}, answer.get(1));
  }
}
