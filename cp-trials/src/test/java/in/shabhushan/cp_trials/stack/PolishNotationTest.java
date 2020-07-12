package in.shabhushan.cp_trials.stack;

import org.junit.Test;

import static in.shabhushan.cp_trials.stack.PolishNotation.getReversePolishNotation;
import static org.junit.Assert.assertEquals;

public class PolishNotationTest {

  @Test
  public void testGetReversePolishNotation() {
    assertEquals("54+33*+", getReversePolishNotation("5+4+(3*3)"));
    assertEquals("ABC*DEF^/G*-H*+", getReversePolishNotation("A+(B*C-(D/E^F)*G)*H"));
  }
}
