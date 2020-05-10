package in.shabhushan.cp_trials.math.algebra;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfSquaresTest {

  @Test
  public void easyTests() {
    assertEquals(4, SumOfSquares.nSquaresFor(15));
    assertEquals(1, SumOfSquares.nSquaresFor(16));
    assertEquals(2, SumOfSquares.nSquaresFor(17));
    assertEquals(2, SumOfSquares.nSquaresFor(18));
    assertEquals(3, SumOfSquares.nSquaresFor(19));
  }
}
