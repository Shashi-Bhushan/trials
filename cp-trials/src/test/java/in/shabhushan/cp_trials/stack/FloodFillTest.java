package in.shabhushan.cp_trials.stack;

import org.junit.Test;

import static in.shabhushan.cp_trials.stack.FloodFill.floodFill;
import static org.junit.Assert.assertArrayEquals;

public class FloodFillTest {
  @Test
  public void testFloodFill() {
    assertArrayEquals(new int[][]{
            new int[]{2, 2, 2}, new int[]{2, 2, 0}, new int[]{2, 0, 1}
        },
        floodFill(new int[][]{
            new int[]{1, 1, 1}, new int[]{1, 1, 0}, new int[]{1, 0, 1}
            },
            1, 1, 2)
    );
  }
}
