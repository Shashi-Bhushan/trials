package in.shabhushan.cp_trials.dfs;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/course-schedule/submissions/
 */
class CourseSchedule {
  public static boolean canFinish(int numCourses, int[][] prerequisites) {
    if (numCourses == 1 || prerequisites.length == 0)
      return true;
    Map<Integer, Set<Integer>> pre = new HashMap<>();

    for (int i =0; i < numCourses; i++) {
      pre.put(i, new HashSet<Integer>());
    }

    for (int[] p: prerequisites) {
      pre.get(p[1]).add(p[0]);
    }

    for (int i = 0; i < numCourses; i++) {
      boolean[] visited = new boolean[numCourses];

      //System.out.println("Checking for " + i);
      if (hasCycle(i, pre, visited)) {
        return false; // can't finish
      }
    }

    return true;
  }

  private static boolean hasCycle(int current, Map<Integer, Set<Integer>> pre, boolean[] visited) {
    //System.out.println(current);
    if (visited[current]) {
      return true;
    } else if (pre.get(current).isEmpty()) {
      return false;
    }

    visited[current] = true;
    for (Integer i: pre.get(current)) {
      if (hasCycle(i, pre, visited)) {
        return true;
      }
    }
    visited[current] = false;

    return false;
  }
}
