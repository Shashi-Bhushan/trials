package in.shabhushan.algo_trials.graph;

import java.util.*;
import java.io.*;

/**
 * Given an undirected and disconnected graph G(V, E), print its BFS traversal.
 *
 * The graph will be passed as an adjacency matrix
 */
public class BFSTraversal {
  public static boolean[][] getGraph(String[] args) {
    String[] s = args[0].split(" ");
    int v = Integer.parseInt(s[0]);
    int e = Integer.parseInt(s[1]);

    boolean[][] graph = new boolean[v][v];

    for (int i = 1; i <= e; i++) {
      String[] x = args[i].split(" ");

      int a = Integer.parseInt(x[0]);
      int b = Integer.parseInt(x[1]);

      graph[a][b] = true;
      graph[b][a] = true;
    }

    return graph;
  }

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

    Queue<Integer> queue = new ArrayDeque<>();

    boolean[] visited = new boolean[v];

    for (int i = 0; i < v; i++) if (visited[i] == false) {
      queue.offer(i);
      visited[i] = true;

      while (!queue.isEmpty()) {
        int size = queue.size();

        for (int k = 0; k < size; k++) {
          int vertex = queue.poll();

          System.out.print(vertex + " ");

          for (int j = 0; j < v; j++) if (vertex != j) {
            // check row of the vertex
            //System.out.println(vertex + " " + j + " " + map[vertex][j] + " " + visited[j]);
            if (map[vertex][j] == true && visited[j] == false) {
              queue.offer(j);
              visited[j] = true;
            }
          }
        }
      }
    }
  }

  public static List<Integer> getBfsTraversal(boolean[][] graph) {
    int vertices = graph.length;

    Queue<Integer> queue = new ArrayDeque<>();

    boolean[] visited = new boolean[vertices];

    List<Integer> result = new ArrayList<>();

    for (int i = 0; i < vertices; i++) if (visited[i] == false) {
      queue.offer(i);
      visited[i] = true;

      while (!queue.isEmpty()) {
        int size = queue.size();

        for (int k = 0; k < size; k++) {
          int vertex = queue.poll();

          result.add(vertex);

          for (int j = 0; j < vertices; j++) if (vertex != j) {
            // check row of the vertex
            //System.out.println(vertex + " " + j + " " + map[vertex][j] + " " + visited[j]);
            if (graph[vertex][j] == true && visited[j] == false) {
              queue.offer(j);
              visited[j] = true;
            }
          }
        }
      }
    }

    return result;
  }

}
