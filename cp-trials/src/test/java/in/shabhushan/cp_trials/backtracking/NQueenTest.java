package in.shabhushan.cp_trials.backtracking;

import org.junit.Test;

import static in.shabhushan.cp_trials.backtracking.NQueen.isSolvable;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class NQueenTest {
  @Test
  public void testNQueen() {
    assertTrue(isSolvable(4));

    assertFalse(isSolvable(3));
  }
}
