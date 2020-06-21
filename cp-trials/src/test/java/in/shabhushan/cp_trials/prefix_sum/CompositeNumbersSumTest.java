package in.shabhushan.cp_trials.prefix_sum;

import org.junit.Test;

import static in.shabhushan.cp_trials.prefix_sum.CompositeNumbersSum.getCompositeNumbersSum;
import static org.junit.Assert.assertEquals;

public class CompositeNumbersSumTest {
  @Test
  public void testCompositeNumbersSum() {
    // in this range 10-13, 10 and 12 are composite
    assertEquals(22, getCompositeNumbersSum(10, 13));
    // in the range 12-22, 12 + 14 + 15 + 16 + 18 + 20 + 21 = 116
    assertEquals(116, getCompositeNumbersSum(12, 21));
  }
}
