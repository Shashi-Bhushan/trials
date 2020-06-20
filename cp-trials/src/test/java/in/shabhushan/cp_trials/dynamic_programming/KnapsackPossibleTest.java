package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.KnapsackPossible.isPossible;
import static in.shabhushan.cp_trials.dynamic_programming.KnapsackPossible.isPossibleDP;
import static org.junit.Assert.assertArrayEquals;

public class KnapsackPossibleTest {
  @Test
  public void testKnapsackPossible() {
    assertArrayEquals(new boolean[]{
        true, true, false, true, true, true, true, true, true, true, false, true, true
    }, isPossible(new int[]{1, 3, 3, 5}));
  }

  @Test
  public void testKnapsackPossibleDP() {
    assertArrayEquals(new boolean[]{
        true, true, false, true, true, true, true, true, true, true, false, true, true
    }, isPossibleDP(new int[]{1, 3, 3, 5}));
  }
}
