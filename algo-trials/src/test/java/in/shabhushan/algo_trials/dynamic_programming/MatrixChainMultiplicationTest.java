package in.shabhushan.algo_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.MatrixChainMultiplication.mcm;
import static org.junit.Assert.assertEquals;

public class MatrixChainMultiplicationTest {
  @Test
  public void testMcm() {
    assertEquals(8000, mcm(new int[]{10, 15, 20, 25}));
  }
}
