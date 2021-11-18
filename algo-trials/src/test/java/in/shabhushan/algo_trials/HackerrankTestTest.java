package in.shabhushan.algo_trials;

import org.junit.Test;

import static in.shabhushan.algo_trials.HackrankTest.getSolution;
import static org.junit.Assert.assertEquals;

public class HackerrankTestTest {
  @Test
  public void test() {
    /**
     *     0 6
     * 0 5 | 1 6
     */
    assertEquals(5, getSolution("FMADASM"));
    assertEquals(5, getSolution("FMADASMN"));
    assertEquals(5, getSolution("MADAM"));
    assertEquals(9, getSolution("AABBXBBAA"));
    assertEquals(5, getSolution("VAVSIBSA"));
    assertEquals(6, getSolution("VAVSIBBSA"));
  }
}
