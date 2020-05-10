package in.shabhushan.cp_trials.dsbook.methods.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dsbook.methods.dynamic_programming.Frog.frogOne;
import static org.junit.Assert.assertEquals;

public class EducationalDPTest {
  @Test
  public void testFrogOne() {
    int test = 4;
    int[] arr = new int[]{10, 30, 40, 20};

    assertEquals(30, frogOne(test, arr));
  }
}
