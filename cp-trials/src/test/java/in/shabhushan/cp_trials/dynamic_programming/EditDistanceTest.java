package in.shabhushan.cp_trials.dynamic_programming;

import org.junit.Test;

import static in.shabhushan.cp_trials.dynamic_programming.EditDistance.editDistance;
import static org.junit.Assert.assertEquals;

public class EditDistanceTest {
  @Test
  public void testEditDistanceDP() {
    assertEquals(3, editDistance("SUNDAY", "SATURDAY"));
    assertEquals(3, editDistance("ABC", "XYZ"));
  }
}
