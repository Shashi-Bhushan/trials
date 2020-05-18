package in.shabhushan.cp_trials.dfs;

/**
 * Leetcode solution for "Number of Islands"
 * https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/530/week-3/3302/
 */
public class CountIslands {
  public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;

    int row = grid.length;
    int column = grid[0].length;

    int answer = 0;
    boolean[][] visited = new boolean[row][column];
    for (int i = 0; i < row; i++) {
      for (int j = 0; j < column; j++) {
        answer += incrementIslandCount(grid, row, column, visited, i, j);
      }
    }

    return answer;
  }

  private static int[][] directions = new int[][]{
      new int[]{0, 1},
      new int[]{0, -1},
      new int[]{1, 0},
      new int[]{-1, 0},
  };

  private int incrementIslandCount(char[][] grid, int row, int column, boolean[][] visited,
                                   int i, int j) {
    if (!isWithinBounds(i, 0, row) || !isWithinBounds(j, 0, column) || grid[i][j] == '0' || visited[i][j])
      return 0;

    markNeighboursAsVisited(grid, row, column, visited, i, j);
    return 1;
  }

  private void markNeighboursAsVisited(char[][] grid, int row, int column, boolean[][] visited, int i, int j) {
    if (isWithinBounds(i, 0, row) && isWithinBounds(j, 0, column)
        && grid[i][j] == '1' && !visited[i][j]) {
      visited[i][j] = true;

      // mark all neighbours visited
      for (int d = 0; d < directions.length; d++) {
        int[] direction = directions[d];

        markNeighboursAsVisited(grid, row, column, visited, i + direction[0], j + direction[1]);
      }
    }
  }

  /**
   * Lower bound is inclusive, upper bound is exclusive
   */
  private boolean isWithinBounds(int value, int lowerBound, int upperBound) {
    return lowerBound <= value && value < upperBound;
  }
}
