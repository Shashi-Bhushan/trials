package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.MaxSubSet.*;
import static org.junit.Assert.assertEquals;

public class MaxSubsetTest {
  @Test
  public void testMaxSubSet() {
    assertEquals(340, maxSubsetSumNoAdjacent(new int[]{75, 105, 120, 75, 10, 90, 135}));
  }

  @Test
  public void testMaxSubSet2() {
    assertEquals(340, maxSubsetSumNoAdjacent2(new int[]{75, 105, 120, 75, 10, 90, 135}));
  }

  @Test
  public void testMaxSubSet3() {
    assertEquals(340, maxSubsetSumNoAdjacent3(new int[]{75, 105, 120, 75, 10, 90, 135}));
  }

  @Test
  public void testMaxSubSet4() {
    //assertEquals(-2 /* -1, -1 */, maxSubsetSumNoAdjacent2(new int[]{-1, -10, -10, -1, -2}));
  }
}
