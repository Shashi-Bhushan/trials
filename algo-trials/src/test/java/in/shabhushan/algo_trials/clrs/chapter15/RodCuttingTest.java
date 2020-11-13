package in.shabhushan.algo_trials.clrs.chapter15;

import org.junit.Test;

import static in.shabhushan.algo_trials.clrs.chapter15.RodCutting.rodCutting;
import static org.junit.Assert.assertEquals;

public class RodCuttingTest {
  @Test
  public void testRodCutting() {
    assertEquals(6, rodCutting(new int[]{3, 5}));
    assertEquals(22, rodCutting(new int[]{1, 5, 8, 9, 10, 17, 17, 20}));
    assertEquals(24, rodCutting(new int[]{3, 5, 8, 9, 10, 17, 17, 20}));
  }
}
