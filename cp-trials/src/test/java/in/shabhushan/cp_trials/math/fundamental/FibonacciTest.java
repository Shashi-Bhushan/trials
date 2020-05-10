package in.shabhushan.cp_trials.math.fundamental;

import org.junit.Test;

import static in.shabhushan.cp_trials.math.fundamental.Fibonacci.fib;
import static in.shabhushan.cp_trials.math.fundamental.Fibonacci.fibTailRec;
import static org.junit.Assert.assertEquals;

public class FibonacciTest {
  @Test
  public void fibonacci() {
    int fib = fib(32);

    assertEquals(3524578, fib);
    assertEquals(7049155, Fibonacci.counter);
  }

  @Test
  public void testFibonacciTailRec() {
    int fib = fibTailRec(32);

    assertEquals(3524578, fib);
    assertEquals(33, Fibonacci.tailRecCounter);
  }
}
