package in.shabhushan.cp_trials.sweepline;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/course-schedule-iii/
 */
class CourseSchedule {
  public static int scheduleCourse(int[][] courses) {
    Arrays.sort(courses, (a, b) -> a[1] - b[1]);

    PriorityQueue<Integer> queue = new PriorityQueue<>((a, b) -> (b - a));

    int totalTime = 0;
    for (int[] course: courses) {

      totalTime += course[0];
      queue.add(course[0]);

      while (!queue.isEmpty() && totalTime > course[1]) {
        int item = queue.poll();
        totalTime -= item;
      }

    }

    return queue.size();
  }
}
