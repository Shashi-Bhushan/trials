package in.shabhushan.cp_trials.backtracking;

import org.junit.Test;

import static in.shabhushan.cp_trials.backtracking.LineOfWines.lineOfWines;
import static org.junit.Assert.assertEquals;

public class LineOfWinesTest {
  @Test
  public void testLineOfwines() {
    assertEquals(64, lineOfWines(new int[]{2, 4, 6, 2, 5}));
  }
}
