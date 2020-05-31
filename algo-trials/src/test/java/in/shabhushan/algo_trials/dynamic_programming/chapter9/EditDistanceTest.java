package in.shabhushan.algo_trials.dynamic_programming.chapter9;

import org.junit.Test;

import static in.shabhushan.algo_trials.dynamic_programming.chapter9.EditDistance.editDistance;
import static in.shabhushan.algo_trials.dynamic_programming.chapter9.EditDistance.editDistanceDP;
import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
  @Test
  public void testEditDistance() {
    //assertEquals(3, editDistance("SUNDAY", "SATURDAY"));
    assertEquals(3, editDistance("ABC", "XYZ"));
  }

  @Test
  public void testEditDistanceDP() {
    assertEquals(3, editDistanceDP("SUNDAY", "SATURDAY"));
    assertEquals(3, editDistanceDP("ABC", "XYZ"));
  }
}
