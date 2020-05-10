package in.shabhushan.cp_trials.string.logic;

import java.util.*;

public class ShortestKnightPath {
  private static final class Point {
    int x;
    int y;

    public Point(int x, int y) {
      this.x = x;
      this.y = y;
    }

    @Override
    public boolean equals(Object o) {
      if (this == o) return true;
      if (!(o instanceof Point)) return false;
      Point point = (Point) o;
      return x == point.x &&
          y == point.y;
    }

    @Override
    public int hashCode() {
      return Objects.hash(x, y);
    }

    public Set<Point> getNextPositions() {
      Set<Point> set = new HashSet<>();
      addIfWithinBoundary(new Point(this.x + 2, this.y + 1), set);
      addIfWithinBoundary(new Point(this.x + 2, this.y - 1), set);
      addIfWithinBoundary(new Point(this.x - 2, this.y - 1), set);
      addIfWithinBoundary(new Point(this.x - 2, this.y + 1), set);
      addIfWithinBoundary(new Point(this.x + 1, this.y + 2), set);
      addIfWithinBoundary(new Point(this.x - 1, this.y + 2), set);
      addIfWithinBoundary(new Point(this.x + 1, this.y - 2), set);
      addIfWithinBoundary(new Point(this.x - 1, this.y - 2), set);

      return set;
    }

    private static void addIfWithinBoundary(Point point, Set<Point> set) {
      if (isWithinBoundary(point))
        set.add(point);
    }

    private static boolean isWithinBoundary(Point point) {
      return 0 <= point.x && point.x < 8 && 0 <= point.y && point.y < 8;
    }
  }

  public static int knight(String start, String finish) {
    // Your code here!
    Point startPoint = new Point(start.charAt(0) - 'a', start.charAt(1) - '1');
    Point finishPoint = new Point(finish.charAt(0) - 'a', finish.charAt(1) - '1');

    return getMinimumSteps(startPoint, finishPoint);
  }

  private static int getMinimumSteps(Point startPoint, Point finishPoint) {
    int steps = -1;
    Set<Point> set = new HashSet<>();

    set.add(startPoint);
    while (!set.isEmpty()) {
      steps++;
      Set<Point> backup = new HashSet<>(set);
      set.clear();

      for (Point point: backup) {
        if (!point.equals(finishPoint))
          set.addAll(point.getNextPositions());
        else
          return steps;
      }
    }

    return steps;
  }


}
