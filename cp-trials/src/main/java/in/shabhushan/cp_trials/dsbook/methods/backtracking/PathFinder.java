package in.shabhushan.cp_trials.dsbook.methods.backtracking;

import java.util.*;
import java.util.stream.Collectors;

public class PathFinder {
  private enum Direction {
    LEFT(0, -1),
    RIGHT(0, 1),
    UP(-1, 0),
    DOWN(1, 0);

    private int x;
    private int y;

    private Direction(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }

    public static Direction getReverseDirection(Direction direction) {
      if (direction.equals(UP))
        return DOWN;
      else if (direction.equals(DOWN))
        return UP;
      else if (direction.equals(LEFT))
        return RIGHT;
      else
        return LEFT;
    }
  }

  private static Direction[] values = {Direction.DOWN, Direction.RIGHT, Direction.UP, Direction.LEFT};

  /**
   * Path Finder One: Does a path exist from start to end
   * @param maze
   * @return
   */
  static boolean pathFinderOne(String maze) {
    final String[] rows = maze.split("\n");
    final Boolean[][] grid = new Boolean[rows.length][];

    for (int i = 0; i < rows.length; i++)
      grid[i] = Arrays.stream(rows[i].split("")).map(chr -> chr.equals(".")).toArray(Boolean[]::new);

    return findExit(new Position(0, 0), grid);
  }

  private static boolean findExit(Position p, Boolean[][] grid) {
    if (p.x == grid.length - 1 && p.x == p.y)
      return true;

    if (!p.onPath(grid))
      return false;

    grid[p.y][p.x] = false;

    final Position[] n = p.neighbours();
    return findExit(n[0], grid) || findExit(n[1], grid) || findExit(n[2], grid) || findExit(n[3], grid);
  }

  /**
   * Path Finder Two: Minimum no of steps from start to end
   */
  public static int pathFinderTwo(String maze) {
    final String[] rows = maze.split("\n");
    final Boolean[][] board = new Boolean[rows.length][];

    for (int i = 0; i < rows.length; i++)
      board[i] = Arrays.stream(rows[i].split("")).map(chr -> chr.equals(".")).toArray(Boolean[]::new);

    Set<Position> bag = new HashSet<>();
    bag.add(new Position(0, 0));

    int step = 0, S = board.length;
    Position end = new Position(S - 1, S - 1);

    board[0][0] = false;
    while (!bag.isEmpty() && !bag.contains(end)) {
      step++;
      bag = bag.stream().flatMap(p -> Arrays.stream(p.neighbours()))
          .filter(p -> p.onPath2(board))
          .peek(p -> board[p.x][p.y] = false)
          .collect(Collectors.toSet());
    }
    return bag.contains(end) ? step : -1;
  }

  /**
   * Path Finder Three: Hills Climb
   */
  public static int pathFinderThree(String maze) {
    final String[] rows = maze.split("\n");
    final Integer[][] hills = new Integer[rows.length][];

    for (int i = 0; i < rows.length; i++)
      hills[i] = Arrays.stream(rows[i].split("")).map(Integer::valueOf).toArray(Integer[]::new);

    Set<Position> visits = new HashSet<>();
    visits.add(new Position(0, 0));

    int[][] climbRounds = createSquare(rows.length);
    climbRounds[0][0] = 0;

    while (!visits.isEmpty()) {
      final Set<Position> lastVisits = new HashSet<>(visits);
      visits.clear();

      for(Position source: lastVisits) {
        Arrays.stream(source.neighbours())
            .filter(neighbour -> neighbour.isInBounds(hills))
            .forEach(neighbour -> {
              int rounds = climbRounds[source.x][source.y] + Math.abs(hills[source.x][source.y] - hills[neighbour.x][neighbour.y]);
              if (rounds < climbRounds[neighbour.x][neighbour.y]) {
                climbRounds[neighbour.x][neighbour.y] = rounds;
                visits.add(neighbour);
              }
            });
      }
    }

    return climbRounds[rows.length - 1][rows.length - 1];
  }

  private static int[][] createSquare(final int size) {
    final int[][] area = new int[size][size];
    for (final int[] row : area) {
      Arrays.fill(row, Integer.MAX_VALUE);
    }
    return area;
  }

  private static class Position {
    final int x, y;

    Position(int x, int y) {
      this.x = x;
      this.y = y;
    }

    Position[] neighbours() {
      return new Position[]{
          new Position(x + 1, y),
          new Position(x, y + 1),
          new Position(x - 1, y),
          new Position(x, y - 1),
      };
    }

    boolean onPath(Boolean[][] grid) {
      return isInBounds(grid) && grid[y][x];
    }

    boolean onPath2(Boolean[][] grid) {
      return isInBounds(grid) && grid[x][y];
    }

    <T> boolean isInBounds(T[][] grid) {
      return x >= 0 && x < grid[0].length && y >= 0 && y < grid.length;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Position)) return false;
      Position position = (Position) o;
      return x == position.x &&
          y == position.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }
  }
}
