package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.CuttingRod.cutRod;
import static in.shabhushan.algo_trials.dynamic_programming.chapter9.CuttingRod.cutRodDP;
import static org.junit.Assert.assertEquals;

public class CuttingRodTest {
  @Test
  public void testCutRod() {
    assertEquals(10, cutRod(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 4));
  }

  @Test
  public void testCutRodDP() {
    assertEquals(10, cutRodDP(new int[]{1, 5, 8, 9, 10, 17, 17, 20}, 4));
  }
}
