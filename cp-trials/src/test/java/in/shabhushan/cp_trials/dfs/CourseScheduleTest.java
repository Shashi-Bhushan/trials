package in.shabhushan.cp_trials.dfs;

import org.junit.Test;

import static in.shabhushan.cp_trials.dfs.CourseSchedule.canFinish;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {
  @Test
  public void testCourseSchedule() {
    assertTrue(canFinish(7, new int[][]{
        {1,0},
        {0,3},
        {0,2},
        {3,2},
        {2,5},
        {4,5},
        {5,6},
        {2,4}
    }));
  }
}
