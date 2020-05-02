package in.shabhushan.algo_trials.algorithms.chapter1.section3;

import org.junit.Test;

import static in.shabhushan.algo_trials.algorithms.chapter1.section3.ExpressionEvaluation.evaluateExpression;
import static org.junit.Assert.assertEquals;

public class ExpressionEvaluationTest {
  @Test
  public void testExpressionEvaluation() {
    assertEquals(5, evaluateExpression("( 4 + 1 )"));
    assertEquals(4, evaluateExpression("( 4 / 1 )"));
    assertEquals(21, evaluateExpression("( ( 4 * 5 ) + 1 )"));
    assertEquals(23, evaluateExpression("( ( 4 * 5 ) + ( 21 / 7 ) )"));
  }
}
