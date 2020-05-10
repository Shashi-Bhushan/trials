package in.shabhushan.cp_trials.math.logic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ProperFractionTest {
  @Test
  public void Smaller_Numbers() {
    assertEquals(0, ProperFractions.properFractions(1));
    assertEquals(1, ProperFractions.properFractions(2));
    assertEquals(4, ProperFractions.properFractions(5));
    assertEquals(8, ProperFractions.properFractions(15));
    assertEquals(20, ProperFractions.properFractions(25));
  }
}
