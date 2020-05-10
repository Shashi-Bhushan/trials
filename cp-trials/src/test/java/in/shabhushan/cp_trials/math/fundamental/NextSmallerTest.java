package in.shabhushan.cp_trials.math.fundamental;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class NextSmallerTest {
  @Test
  public void basicTests() {
    assertEquals(12, NextSmaller.nextSmaller(21));
    assertEquals(790, NextSmaller.nextSmaller(907));
    assertEquals(513, NextSmaller.nextSmaller(531));
    assertEquals(-1, NextSmaller.nextSmaller(1027));
    assertEquals(414, NextSmaller.nextSmaller(441));
    assertEquals(123456789, NextSmaller.nextSmaller(123456798));
  }
}
