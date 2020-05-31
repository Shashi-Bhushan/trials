package in.shabhushan.cp_trials.sweepline;

import org.junit.Test;

import static in.shabhushan.cp_trials.sweepline.RightInterval.findRightInterval;
import static in.shabhushan.cp_trials.sweepline.RightInterval.findRightInterval2;
import static org.junit.Assert.assertArrayEquals;

public class RightIntervalTest {
  @Test
  public void testRightInterval() {
    assertArrayEquals(new int[]{-1}, findRightInterval(new int[][]{
        {1,2}
    }));
    assertArrayEquals(new int[]{-1, 0, 1}, findRightInterval(new int[][]{
        {3,4}, {2,3}, {1,2}
    }));
    assertArrayEquals(new int[]{-1, 2, -1}, findRightInterval(new int[][]{
        {1,6}, {2,3}, {4,5}
    }));
  }

  @Test
  public void testRightInterval2() {
    assertArrayEquals(new int[]{-1}, findRightInterval2(new int[][]{
      {1,2}
    }));
    assertArrayEquals(new int[]{-1, 0, 1}, findRightInterval2(new int[][]{
        {3,4}, {2,3}, {1,2}
    }));
    assertArrayEquals(new int[]{-1, 2, -1}, findRightInterval2(new int[][]{
        {1,6}, {2,3}, {4,5}
    }));
  }
}
