package in.shabhushan.cp_trials.array;

import org.junit.Test;

import static in.shabhushan.cp_trials.array.UglyNumbersII.nthUglyNumber;
import static org.junit.Assert.assertEquals;

public class UglyNumbersIITest {
  @Test
  public void testUglyNumbers() {
    assertEquals(15, nthUglyNumber(11));
  }
}
