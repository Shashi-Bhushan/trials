package in.shabhushan.cp_trials.array;

import org.junit.Test;

import static in.shabhushan.cp_trials.array.ProductOfOtherNumbers.productOfOtherNumbers;
import static org.junit.Assert.assertArrayEquals;

public class ProductOfOtherNumbersTest {
  @Test
  public void testProductOfOtherNumbers() {
    assertArrayEquals(new int[]{540, 270, 90, 108, 60}, productOfOtherNumbers(new int[]{1, 2, 6, 5, 9}));
  }
}
