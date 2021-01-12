package in.shabhushan.algo_trials.binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgreesiveCowsTest {
  private final AgreesiveCows cows = new AgreesiveCows();

  @Test
  public void testAggresiveCows() {
    assertEquals(2, cows.solve(new int[]{1, 2, 3, 4, 5}, 3));
    assertEquals(95, cows.solve(new int[]{5, 17, 100, 11}, 2));
    assertEquals(7, cows.solve(new int[]{82, 61, 38, 88, 12, 7, 6, 12, 48, 8, 31, 90, 35, 5, 88, 2, 66, 19, 5, 96, 84, 95}, 8));
  }
}
