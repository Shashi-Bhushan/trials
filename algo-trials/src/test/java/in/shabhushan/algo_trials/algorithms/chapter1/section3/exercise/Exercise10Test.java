package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise.Exercise10.infixToPostfix;
import static org.junit.Assert.assertEquals;

public class Exercise10Test {
  @Test
  public void testInfixToPostfix() {
    assertEquals("1 2 + 4 2 / *", infixToPostfix("( ( 1 + 2 ) * ( 4 / 2 ) )"));
  }
}
