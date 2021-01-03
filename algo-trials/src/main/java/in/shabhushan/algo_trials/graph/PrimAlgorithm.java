package in.shabhushan.algo_trials.graph;

import java.util.*;

public class PrimAlgorithm {
  public static void main(String[] args) {
    Scanner s = new Scanner(System.in);
    int V = s.nextInt();
    int E = s.nextInt();

    /* Write Your Code Here
     * Complete the Rest of the Program
     * You have to take input and print the output yourself
     */

    int[][] graph = new int[V][V];

    for (int i = 0; i < E; i++) {
      int v1 = s.nextInt();
      int v2 = s.nextInt();
      int w = s.nextInt();

      graph[v1][v2] = w;
      graph[v2][v1] = w;
    }

    int[] parents = new int[V];

    int[] distanceFromRoot = new int[V];
    Arrays.fill(distanceFromRoot, Integer.MAX_VALUE);

    boolean[] visited = new boolean[V];

    // always assign 0 as MST parent
    int key = 0;
    parents[key] = -1;
    distanceFromRoot[key] = 0;

    for (int i = 0; i < V - 1; i++) {
      // find vertex index with minimum weight
      int minIndex = min(visited, distanceFromRoot);

      // mark vertex as visited
      visited[minIndex] = true;

      //System.out.println("minindex " + minIndex);

      // find neighbours of vertex at minIndex
      for (int j = 0; j < V; j++) {
        if (graph[minIndex][j] != 0 && visited[j] == false && graph[minIndex][j] < distanceFromRoot[j]) {
          parents[j] = minIndex;
          distanceFromRoot[j] = graph[minIndex][j];

          //System.out.println(minIndex + " " + j + " " + distanceFromRoot[j]);
        }
      }
    }

    for (int i = 1; i < parents.length; i++) {
      if (i < parents[i])
        System.out.println(i + " " + parents[i] + " " + distanceFromRoot[i]);
      else
        System.out.println(parents[i] + " " + i + " " + distanceFromRoot[i]);
    }
  }

  private static int min(boolean[] visited, int[] weights) {
    int minIndex = Integer.MAX_VALUE;
    int min = Integer.MAX_VALUE;

    for (int i = 0; i < weights.length; i++) {
      if (visited[i] == false && weights[i] < min) {
        min = weights[i];
        minIndex = i;
      }
    }

    return minIndex;
  }
}
