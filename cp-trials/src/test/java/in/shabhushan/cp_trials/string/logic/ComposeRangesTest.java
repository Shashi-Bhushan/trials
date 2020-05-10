package in.shabhushan.cp_trials.string.logic;

import org.junit.Test;

import static in.shabhushan.cp_trials.string.logic.ComposeRanges.composeRanges;
import static org.junit.Assert.assertArrayEquals;

public class ComposeRangesTest {
  @Test
  public void testComposeRanges() {
    assertArrayEquals(new String[]{
        "-1->2", "6->7", "9"
    }, composeRanges(new int[]{-1, 0, 1, 2, 6, 7, 9}));

    assertArrayEquals(new String[]{
        "-5", "3->5", "20->22"
    }, composeRanges(new int[]{-5, 3, 4, 5, 20, 21, 22}));
  }
}
