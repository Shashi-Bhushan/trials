package in.shabhushan.cp_trials.graph;

import java.util.*;

import static java.util.Map.entry;

/**
 * Leetcode solution for
 * https://leetcode.com/contest/weekly-contest-191/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/
 *
 * Create an array of List<Pair<Source, IsRealConnection>>. index represent the node.
 * Eg from Test case 0, from Node 0, there would be a real connection to 1 and and a fake connection to 4
 * Count number of fake connection using dfs
 *
 * Check https://www.youtube.com/watch?v=3Ei6JGdoueg for reference
 */
class MinimumReorder {
  public static int minReorder(int n, int[][] connections) {
    // List<Pair<Source, IsRealConnection>>
    List<Map.Entry<Integer, Boolean>>[] g = new List[n];

    for (int i = 0; i < n; i++) {
      g[i] = new ArrayList<>();
    }

    for (int[] con: connections) {
      g[con[0]].add(entry(con[1], true));
      g[con[1]].add(entry(con[0], false));
    }

    return dfs(g, 0, 0);
  }

  private static int dfs(List<Map.Entry<Integer, Boolean>>[] g, int start, int parent) {
    int answer = 0;

    for (Map.Entry<Integer, Boolean> pair: g[start]) {
      // key is node value, if it's parent ignore it
      if (pair.getKey() != parent) {
        if (pair.getValue()) {
          answer++;
        }

        answer += dfs(g, pair.getKey(), start);
      }
    }

    return answer;
  }
}

