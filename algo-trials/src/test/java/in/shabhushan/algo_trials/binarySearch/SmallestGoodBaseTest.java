package in.shabhushan.algo_trials.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestGoodBaseTest {
  SmallestGoodBase base = new SmallestGoodBase();

  @Test
  public void testSmallestGoodBase() {
    assertEquals("3", base.solve("13"));
  }
}
