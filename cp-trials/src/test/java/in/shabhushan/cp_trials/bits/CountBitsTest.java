package in.shabhushan.cp_trials.bits;

import org.junit.Test;

import static in.shabhushan.cp_trials.bits.CountBits.countBits;
import static org.junit.Assert.assertArrayEquals;

public class CountBitsTest {
  @Test
  public void testCountBits() {
    assertArrayEquals(new int[]{0, 1, 1}, countBits(2));
    assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2, 2, 3, 1, 2, 2, 3, 2, 3, 3, 4}, countBits(15));
  }
}
