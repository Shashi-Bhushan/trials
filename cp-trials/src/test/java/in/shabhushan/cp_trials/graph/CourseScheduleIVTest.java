package in.shabhushan.cp_trials.graph;

import org.junit.Test;

import java.util.List;

import static in.shabhushan.cp_trials.graph.CourseScheduleIV.checkIfPrerequisite;
import static org.junit.Assert.assertEquals;

public class CourseScheduleIVTest {
  @Test
  public void testCourseSchedule() {
    assertEquals(List.of(false, true), checkIfPrerequisite(2, new int[][]{{1, 0}}, new int[][]{{0, 1}, {1, 0}}));
    assertEquals(List.of(false, false), checkIfPrerequisite(2, new int[][]{}, new int[][]{{1, 0}, {0, 1}}));
    assertEquals(List.of(true, true), checkIfPrerequisite(3, new int[][]{{1, 2}, {1, 0}, {2, 0}}, new int[][]{{1, 0}, {1, 2}}));
    assertEquals(List.of(false, true), checkIfPrerequisite(3, new int[][]{{1, 0}, {2, 0}}, new int[][]{{0, 1}, {2, 0}}));
    assertEquals(List.of(true, false, true, false),
        checkIfPrerequisite(5, new int[][]{{0, 1}, {1, 2}, {2, 3}, {3, 4}}, new int[][]{{0, 4}, {4, 0}, {1, 3}, {3, 0}}));
  }
}
