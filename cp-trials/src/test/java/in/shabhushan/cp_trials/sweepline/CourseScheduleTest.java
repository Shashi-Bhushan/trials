package in.shabhushan.cp_trials.sweepline;

import org.junit.Test;

import static in.shabhushan.cp_trials.sweepline.CourseSchedule.scheduleCourse;
import static org.junit.Assert.assertEquals;

public class CourseScheduleTest {
  @Test
  public void testCourseSchedule() {
    assertEquals(3, scheduleCourse(new int[][]{
        new int[]{100, 200},
        new int[]{200, 1300},
        new int[]{1000, 1250},
        new int[]{2000, 3200}
    }));
    assertEquals(2, scheduleCourse(new int[][]{
        new int[]{5, 5},
        new int[]{4, 6},
        new int[]{2, 6}
    }));
  }
}
