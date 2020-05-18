package in.shabhushan.cp_trials.competition.atcoder;

import org.junit.Test;

import static in.shabhushan.cp_trials.competition.atcoder.ABC166.problemD;
import static org.junit.Assert.assertArrayEquals;

public class ABC166Test {
  @Test
  public void testProblemD() {
    assertArrayEquals(new long[]{1, -2}, problemD(33));
    assertArrayEquals(new long[]{1, 0}, problemD(1));
    assertArrayEquals(new long[]{45, 23}, problemD(178091782));
  }
}
