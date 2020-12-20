package in.shabhushan.algo_trials.graph;

public class CodingNinjas {
  /**
   * Coding Ninjas
   *  * Given a NxM matrix containing Uppercase English Alphabets only. Your task is to tell if there is a path in the given matrix which makes the sentence “CODINGNINJA” .
   *  * There is a path from any cell to all its neighbouring cells. For a particular cell, neighbouring cells are those cells that share an edge or a corner with the cell.
   *  * Input Format :
   *  * The first line of input contains two space separated integers N and M, where N is number of rows and M is the number of columns in the matrix.
   *  * Each of the following N lines contain M characters. Please note that characters are not space separated.
   *  * Output Format :
   *  * Print 1 if there is a path which makes the sentence “CODINGNINJA” else print 0.
   *  * Constraints :
   *  * 1 <= N <= 1000
   *  * 1 <= M <= 1000
   *  * Time Limit: 1 second
   *  * Sample Input 1:
   *  * 2 11
   *  * CXDXNXNXNXA
   *  * XOXIXGXIXJX
   *  * Sample Output 1:
   *  * 1
   */
  public static int solve(String[] Graph , int N, int M)
  {
    /* Your class should be named Solution
     * Don't write main().
     * Don't read input, it is passed as function argument.
     * Return output and don't print it.
     * Taking input and printing output is handled automatically.
     */
    boolean[][] visited = new boolean[N][M];

    for (int i = 0; i < N; i++) {
      for (int j = 0; j < M; j++) {
        if (Graph[i].charAt(j) == 'C') {
          visited[i][j] = true;

          if (helper(Graph, visited, i, j, 1)) {
            return 1;
          }

          visited[i][j] = false;
        }
      }
    }

    return 0;
  }

  private static final String codingNinjas = "CODINGNINJA";

  private static final int[][] DIRECTIONS = {
      {-1, -1},
      {-1, 0},
      {-1, 1},
      {0, -1},
      {0, 1},
      {1, -1},
      {1, 0},
      {1, 1}
  };

  private static boolean helper(String[] graph, boolean[][] visited, int i, int j, int index) {
    if (index == codingNinjas.length()) return true;

    for (int[] dir: DIRECTIONS) {
      int x = i + dir[0];
      int y = j + dir[1];

      if (isWithinBounds(graph, x, y) && visited[x][y] == false && graph[x].charAt(y) == codingNinjas.charAt(index)) {
        visited[x][y] = true;

        if (helper(graph, visited, x, y, index + 1))
          return true;

        visited[x][y] = false;
      }
    }

    return false;
  }

  private static final boolean isWithinBounds(String[] graph, int i, int j) {
    return 0 <= i && i < graph.length && 0 <= j && j < graph[0].length();
  }
}
