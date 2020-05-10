package in.shabhushan.cp_trials.math.algebra;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.algebra.SquareRoot.isPerfectSquareVersion1;
import static in.shabhushan.cp_trials.math.algebra.SquareRoot.isPerfectSquareVersion2;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SquareRootTest {
  @Test
  public void testSquareRootVersion1() {
    assertTrue(isPerfectSquareVersion1(46340 * 46340));
    assertFalse(isPerfectSquareVersion1(2147483647));
  }

  @Test
  public void testSquareRootVersion2() {
    assertTrue(isPerfectSquareVersion2(46340 * 46340));
    assertFalse(isPerfectSquareVersion2(2147483647));
  }
}
