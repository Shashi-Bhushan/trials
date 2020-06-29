package in.shabhushan.cp_trials.graph;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/is-graph-bipartite/submissions/
 *
 * check this for reference
 * https://www.youtube.com/watch?v=y22G2QXwpiI
 */
class GraphBipartite {
  public boolean isBipartite(int[][] graph) {
    int n = graph.length;
    int[] colors = new int[n];
    
    for (int i = 0; i < n; i++) {
      if (colors[i] == 0) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(i);
        colors[i] = 1;
        
        
        while (!queue.isEmpty()) {
          int current = queue.poll();
          
          for (int next: graph[current]) {
            if (colors[next] == 0) {
              colors[next] = -colors[current];
              queue.add(next);
            } else if (colors[next] == colors[current]) {
              return false;
            }
          }
        }
      }
    }
    
    return true;
  }
}
