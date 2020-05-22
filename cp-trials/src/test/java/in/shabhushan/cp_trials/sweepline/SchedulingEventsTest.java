package in.shabhushan.cp_trials.sweepline;

import org.junit.Test;

import static in.shabhushan.cp_trials.sweepline.SchedulingEvents.maxEvents;
import static org.junit.Assert.assertEquals;

public class SchedulingEventsTest {
  @Test
  public void testMaxEvents() {
    assertEquals(2, maxEvents(new int[][]{
      new int[]{0, 2},
      new int[]{1, 2},
      new int[]{1, 4},
      new int[]{2, 8},
      new int[]{5, 7},
    }));
    assertEquals(2, maxEvents(new int[][]{
        new int[]{0, 5},
        new int[]{4, 7},
        new int[]{6, 10}
    }));
    assertEquals(2, maxEvents(new int[][]{
        new int[]{0, 10},
        new int[]{1, 4},
        new int[]{5, 9}
    }));
  }
}
