package in.shabhushan.cp_trials.graph;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/course-schedule-iv/
 */
class CourseScheduleIV {
  public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {
    // Map<Course, Set<Prerequisite>>
    Map<Integer, Set<Integer>> pre = new HashMap<>();

    for (int i = 0; i < n; i++) {
      pre.put(i, new HashSet<Integer>());
    }

    for (int[] p: prerequisites) {
      pre.get(p[0]).add(p[1]);
    }

    List<Boolean> answer = new ArrayList<>();

    for (int[] query : queries) {
      answer.add(solve(pre, query));
    }

    return answer;
  }

  // is p[1] a parent of p[0]
  private static boolean solve(Map<Integer, Set<Integer>> pre, int[] query) {
    Stack<Integer> stack = new Stack<>();
    Set<Integer> seen = new HashSet<>();

    seen.add(query[0]);
    stack.push(query[0]);
    // if not found in set
    while (!stack.isEmpty()) {
      int item = stack.pop();


      if (item == query[1]) {
        return true;
      }

      for (int x : pre.get(item)) {
        if (!seen.contains(x)) {
          stack.push(x);
          seen.add(x);
        }
      }
    }

    return false;
  }
}
