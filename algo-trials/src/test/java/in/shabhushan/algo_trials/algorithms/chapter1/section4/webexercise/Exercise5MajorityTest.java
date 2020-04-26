package in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise.Exercise5Majority.majority;
import static in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise.Exercise5Majority.majorityHashMap;
import static org.junit.Assert.assertEquals;

public class Exercise5MajorityTest {
  @Test
  public void testMajority() {
    assertEquals(3, majority(new int[]{3, 9, 1, 3, 5, 3, 3}));
    assertEquals(8, majority(new int[]{8, 8, 8, 8, 8, 10, 10}));
    assertEquals(-1, majority(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }

  @Test
  public void testMajorityHashMap() {
    assertEquals(3, majorityHashMap(new int[]{3, 9, 1, 3, 5, 3, 3}));
    assertEquals(8, majorityHashMap(new int[]{8, 8, 8, 8, 8, 10, 10}));
    assertEquals(-1, majorityHashMap(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}));
  }
}
