package in.shabhushan.algo_trials.algorithms.chapter1.section2.webexercise;

import edu.princeton.cs.algs4.StdOut;
import org.junit.Test;

import java.lang.reflect.Field;

import static in.shabhushan.algo_trials.algorithms.chapter1.section2.webexercise.Exercise6.isCircularShifted;
import static org.junit.Assert.assertTrue;

public class Exercise6Test {
  @Test
  public void testCircularShiftedArray() {
    assertTrue(isCircularShifted("ACTGACG", "TGACGAC"));
  }

  @Test
  public void test() throws NoSuchFieldException, IllegalAccessException {
    Integer x = 17;
    StdOut.println("Initial value for x is " + x);

    mutate(x);
    StdOut.println("Final value for x is " + x);
  }

  // change the Integer to 9999999
  public static void mutate(Integer x) throws NoSuchFieldException, IllegalAccessException {
      Field value = Integer.class.getDeclaredField("value");
      value.setAccessible(true);
      value.setInt(x, 123);
  }
}
