package in.shabhushan.cp_trials.tree;

import java.util.Arrays;

public class KruskalAlgorithm {
  public static int getMinimumSpanningWeight(int vertices, int[][] graph) {
    Arrays.sort(graph, (a, b) -> a[2] - b[2]);

    int[] parent = new int[vertices];

    for (int i = 0; i < vertices; i++) {
      parent[i] = i;
    }

    int ans = 0;

    int count = 0;
    int i = 0;
    while (count < vertices - 1) {
      int[] edge = graph[i++];

      int src = edge[0];
      int dest = edge[1];
      int weight = edge[2];

      if (parent[src] == src && parent[dest] == dest) {
        parent[dest] = src;
        ans += weight;
        count++;
      } else if (parent[src] == src) {
        parent[src] = dest;
        ans += weight;
        count++;
      } else if (parent[dest] == dest) {
        parent[dest] = src;
        ans += weight;
         count++;
      }
    }

    return ans;
  }
}
