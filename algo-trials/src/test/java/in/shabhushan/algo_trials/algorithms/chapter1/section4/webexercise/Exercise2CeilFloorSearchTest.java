package in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section4.webexercise.Exercise2CeilFloorSearch.getFloorCeil;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Exercise2CeilFloorSearchTest {
  @Test
  public void testCeilFloor() {
    int[] input = {1, 2, 8, 10, 10, 12, 19};

    assertArrayEquals(new int[]{-1, 1}, getFloorCeil(input, 0));
    assertArrayEquals(new int[]{1, 1}, getFloorCeil(input, 1));
    assertArrayEquals(new int[]{2, 8}, getFloorCeil(input, 5));
    assertArrayEquals(new int[]{19, -1}, getFloorCeil(input, 20));
  }
}
