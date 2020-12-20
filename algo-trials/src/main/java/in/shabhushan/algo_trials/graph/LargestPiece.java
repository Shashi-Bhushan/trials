package in.shabhushan.algo_trials.graph;

/**
 *
 * Largest Piece
 * Send Feedback
 * It's Gary's birthday today and he has ordered his favourite square cake consisting of '0's and '1's .
 * But Gary wants the biggest piece of '1's and no '0's . A piece of cake is defined as a part which consist of only '1's, and all '1's share an edge with each other on the cake.
 * Given the size of cake N and the cake, can you find the count of '1's in the biggest piece of '1's for Gary ?
 * Input Format :
 * The first line of input contains an integer, that denotes the value of N.
 * Each of the following N lines contain N space separated integers.
 * Output Format :
 * Print the count of '1's in the biggest piece of '1's, according to the description in the task.
 * Constraints :
 * 1 <= N <= 1000
 * Time Limit: 1 sec
 * Sample Input 1:
 * 2
 * 1 1
 * 0 1
 * Sample Output 1:
 * 3
 */

import java.util.Arrays;

/**
 * 1
 * 1
 *
 * => 1
 *
 * 2
 * 1 1
 * 0 1
 *
 * => 3
 *
 * 3
 * 1 0 0
 * 0 1 0
 * 0 1 0
 *
 * => 2
 */
public class LargestPiece {
  static int[][] dir = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };

  public static int dfs(String[] edge, int n) {
    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     */
    boolean[][] visited = new boolean[n][n];

    int[][] edges = new int[n][n];

    for (int i = 0; i < n; i++) {
      edges[i] = Arrays.stream(edge[i].split(" ")).mapToInt(Integer::parseInt).toArray();
    }

    int max = 0;

    for (int i = 0; i < edges.length; i++) {
      for (int j = 0; j < edges[i].length; j++) {
        if (edges[i][j] == 1) {
          max = Math.max(max,
              1 + helper(edges, i, j, visited));
        }
      }
    }

    return max;
  }

  private static int helper(int[][] edges, int i, int j, boolean[][] visited) {
    if (visited[i][j] == true) return 0;
    else {
      visited[i][j] = true;

      int ans = 0;

      for (int[] d: dir) {
        int x = i + d[0];
        int y = j + d[1];

        if (isWithinBounds(edges, x, y) && visited[x][y] == false && edges[x][y] == 1) {
          ans += (1 + helper(edges, x, y, visited));
        }
      }

      return ans;
    }
  }

  private static final boolean isWithinBounds(int[][] graph, int i, int j) {
    return 0 <= i && i < graph.length && 0 <= j && j < graph[0].length;
  }
}
