package in.shabhushan.algo_trials.graph;

import java.util.*;
import java.io.IOException;

public class GetPath {

  /**
   * Given an undirected graph G(V, E) and two vertices v1 and v2(as integers), find and print the path from v1 to v2 (if exists). Print nothing if there is no path between v1 and v2.
   * Find the path using DFS and print the first path that you encountered.
   * <p>
   * 4 4
   * 0 1
   * 0 3
   * 1 2
   * 2 3
   * 1 3
   * <p>
   * 3 0 1
   * <p>
   * 6 3
   * 5 3
   * 0 1
   * 3 4
   * 0 3
   * <p>
   * ""
   * <p>
   * 9 10
   * 0 8
   * 1 6
   * 1 7
   * 1 8
   * 5 8
   * 6 0
   * 7 3
   * 7 4
   * 8 7
   * 2 5
   * 3 8
   * <p>
   * 8 0 6 1 7 3
   */
  public static void main(String[] args) throws NumberFormatException, IOException {

    /* Write Your Code Here
     * Complete the Rest of the Program
     * You have to take input and print the output yourself
     */

    Scanner input = new Scanner(System.in);

    int v = input.nextInt();
    int e = input.nextInt();

    if (v == 0) return;

    boolean[][] map = new boolean[v][v];

    for (int i = 0; i < e; i++) {
      int a = input.nextInt();
      int b = input.nextInt();

      map[a][b] = true;
      map[b][a] = true;
    }


    int source = input.nextInt();
    int dest = input.nextInt();

    boolean[] visited = new boolean[v];
    //visited[first] = true;

    printDFS(map, source, dest, visited);

    boolean[] visitedBfs = new boolean[v];
    visited[source] = true;


    List<Integer> l = new ArrayList<>();

    l.add(source);

    helper(map, l, dest, visitedBfs);
  }

  private static boolean printDFS(boolean[][] graph, int first, int second, boolean[] visited) {
    //System.out.println(first + " " + second);
    if (visited[first] == false) {
      visited[first] = true;
      //System.out.println(first + " -- " + second);
      if (first == second) {
        System.out.print(second + " ");
        return true;
      }

      for (int i = 0; i < visited.length; i++)
        if (i != first) {
          //System.out.println(first + " " + i + " - " + graph[first][i] + " " + visited[i]);

          if (graph[first][i] == true && visited[i] == false) {
            //visited[i] = true;
            boolean result = printDFS(graph, i, second, visited);

            if (result) {
              System.out.print(first + " ");
              return true;
            }
          }
        }
    }

    return false;
  }

  private static boolean helper(boolean[][] graph, List<Integer> sourceList, int dest, boolean[] visited) {
    if (!sourceList.isEmpty()) {
      for (int source : sourceList) {
        if (source == dest) {
          System.out.print(source + " ");
          return true;
        }

        List<Integer> l = new ArrayList<>();

        for (int i = 0; i < visited.length; i++) {
          if (visited[i] == false && graph[source][i] == true) {
            visited[i] = true;
            l.add(i);
          }
        }

        if (helper(graph, l, dest, visited)) {
          System.out.print(source + " ");

          return true;
        }
      }
    }

    return false;
  }
}
