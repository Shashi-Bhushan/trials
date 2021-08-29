package in.shabhushan.algo_trials.arrays;

import org.junit.Test;

import static in.shabhushan.algo_trials.arrays.MaximumArray.maximumArray;
import static org.junit.Assert.assertEquals;

public class MaximumArrayTest {
  @Test
  public void test() {
    assertEquals(17, maximumArray(new int[]{2,-1,-4,-3}));
    assertEquals(27, maximumArray(new int[]{-1, -1, 5, -1, -1, 4}));
  }

}
