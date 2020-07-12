package in.shabhushan.cp_trials.graph;

import java.util.*;

/**
 * Leetcode solution for
 * https://leetcode.com/problems/path-with-maximum-probability/
 *
 * check https://www.youtube.com/watch?v=riHkdGCYqC0
 */
public class MaxProbability {
  public double maxProbability(int n, int[][] edges, double[] succProb, int start, int end) {
    Map<Integer, List<Map.Entry<Integer, Double>>> adj = new HashMap<>();

    for (int i = 0; i < n; i++)
      adj.put(i, new ArrayList<>());

    for (int i = 0; i < edges.length; i++) {
      adj.get(edges[i][0]).add(Map.entry(edges[i][1], succProb[i]));
      adj.get(edges[i][1]).add(Map.entry(edges[i][0], succProb[i]));
    }

    double[] prob = new double[n];
    prob[start] = 1.0;

    boolean[] visited = new boolean[n];
    visited[start] = true;

    Queue<Integer> queue = new LinkedList<>();
    queue.offer(start);

    while (!queue.isEmpty()) {
      int node = queue.poll();
      visited[node] = false;

      for (Map.Entry<Integer, Double> entry: adj.get(node)) {
        int destNode = entry.getKey();
        double probability = entry.getValue();

        // if prob of reach the currDest node is more than prob of existing path to currDest
        if (prob[destNode] < prob[node] * probability) {
          prob[destNode] = prob[node] * probability;

          if (!visited[destNode]) {
            visited[destNode] = true;
            queue.offer(destNode);
          }
        }
      }
    }


    return prob[end];
  }
}
