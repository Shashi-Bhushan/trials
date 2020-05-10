package in.shabhushan.cp_trials.array;

import java.util.HashSet;
import java.util.List;
import java.util.Objects;

class Point {
    private int first;
    private int second;

    public Point(int first, int second) {
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Point)) return false;
        Point point = (Point) o;
        return getFirst() == point.getFirst() &&
                getSecond() == point.getSecond();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getFirst(), getSecond());
    }
}

public class RottingTomatoes {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;

        var rottenSet = new HashSet<List<Integer>>();
        var freshSet = new HashSet<List<Integer>>();

        for (int row = 0; row < grid.length; row++) {
            for (int column = 0; column < grid[row].length; column++) {
                if (grid[row][column] == 2){
                    rottenSet.add(List.of(row, column));
                }

                else if (grid[row][column] == 1)
                    freshSet.add(List.of(row, column));
            }
        }

        var directions = new int[][]{
                {1, 0},
                {0, 1},
                {-1, 0},
                {0, -1}
        };

        while (!freshSet.isEmpty()) {
            var newRottenSet = new HashSet<List<Integer>>();

            for (List<Integer> list: rottenSet) {
                for(int[] direction: directions) {
                    int i = list.get(0) + direction[0];
                    int j = list.get(1) + direction[1];

                    var potentialPoint = List.of(i, j);
                    if (freshSet.contains(potentialPoint)) {
                        freshSet.remove(potentialPoint);
                        newRottenSet.add(potentialPoint);
                    }
                }
            }

            if (newRottenSet.isEmpty())
                return -1;

            rottenSet = newRottenSet;
            minutes++;
        }

        return minutes;
    }
}
