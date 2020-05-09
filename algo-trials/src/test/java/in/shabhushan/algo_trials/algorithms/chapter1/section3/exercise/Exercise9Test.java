package in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section3.exercise.Exercise9.getInfixExpression;
import static org.junit.Assert.assertEquals;

public class Exercise9Test {
  @Test
  public void testToInfixExpression() {
    assertEquals("( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )", getInfixExpression("1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )"));
  }
}
