package in.shabhushan.cp_trials.stack;

import org.junit.Ignore;
import org.junit.Test;

import static in.shabhushan.cp_trials.stack.FloodFill.floodFill;
import static in.shabhushan.cp_trials.stack.FloodFill.floodFill2;
import static org.junit.Assert.assertArrayEquals;

/**
 * Ideally I should be using JMH for microbenchmarks here. meh, not able to make it work for now.
 * TODO: try to implement JMH for this test case
 */
public class FloodFillTest {
  @Test
  public void testFloodFill() {
    //for (int i = 0; i < 10000; i++) {
    assertArrayEquals(new int[][]{
            new int[]{2, 2, 2}, new int[]{2, 2, 0}, new int[]{2, 0, 1}
        },
        floodFill(new int[][]{
                new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}
            },
            1, 1, 2)
    );
    //}
  }

  @Ignore
  @Test
  public void testFloodFill2() {
    //for (int i = 0; i < 10000; i++) {
    assertArrayEquals(new int[][]{
            new int[]{2, 2, 2}, new int[]{2, 2, 0}, new int[]{2, 0, 1}
        },
        floodFill2(new int[][]{
                new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}
            },
            1, 1, 2)
    );
    //}
  }
}
