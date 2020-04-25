package in.shabhushan.algo_trials.algorithms.chapter1.webassignment;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

  // keeps track of connections between the sites
  private final WeightedQuickUnionUF union;

  private final WeightedQuickUnionUF blueDotNetwork;

  // Keeps track of if the site is open or not, open signifies a porous entry in grid
  // by default, all sites are close
  private int gridSize;
  private final boolean[][] grid;

  private int topSite;
  private int bottomSite;

  private int numOpenSites;

  // creates n-by-n grid, with all sites initially blocked
  public Percolation(int n) {
    if (n <= 0) {
      throw new IllegalArgumentException("N must be at least 1");
    }

    gridSize = n;
    grid = new boolean[gridSize][gridSize];

    // 2 extra positions for virtual top and bottom sites
    union = new WeightedQuickUnionUF(gridSize * gridSize + 2);

    blueDotNetwork = new WeightedQuickUnionUF(gridSize * gridSize + 1);

    topSite = 0;
    bottomSite = gridSize * gridSize + 1;

    numOpenSites = 0;
  }

  /**
   * opens the site (row, col) if it is not open already
   */
  public void open(int row, int col) {
    if (!isOpen(row, col)) {
      int fieldIndex = getFieldIndex(row, col);

      if (row == 1) {
        union.union(topSite, fieldIndex);
        blueDotNetwork.union(topSite, fieldIndex);
      }

      if (row == gridSize) {
        union.union(bottomSite, fieldIndex);
      }

      for (Directions direction : Directions.values()) {
        int newRow = row + direction.getX();
        int newColumn = col + direction.getY();

        if (isWithinBound(newRow, newColumn)) {
          connect(fieldIndex, newRow, newColumn);
        }
      }

      grid[row - 1][col - 1] = true;
      numOpenSites++;
    }
  }

  /**
   * is the site (row, col) open?
   */
  public boolean isOpen(int row, int col) {
    return grid[row - 1][col - 1];
  }

  /**
   * is the site (row, col) full i.e. connected to the top?
   */
  public boolean isFull(int row, int col) {
    if (isOpen(row, col)) {
      int fieldIndex = getFieldIndex(row, col);

      return blueDotNetwork.connected(fieldIndex, topSite);
    }
    else
      return false;
  }

  // returns the number of open sites
  public int numberOfOpenSites() {
    return numOpenSites;
  }

  // does the system percolate?
  public boolean percolates() {
    return union.connected(topSite, bottomSite);
  }

  /**
   * Converts a one based row and col value to a single integer index for Union Find DS
   */
  private int getFieldIndex(int row, int col) {
    return (row - 1) * gridSize + col;
  }

  /**
   * Returns true iff row and column is between 1 and gridSize
   */
  private boolean isWithinBound(int row, int column) {
    return 0 < row && row <= gridSize && 0 < column && column <= gridSize;
  }

  private void connect(int fieldIndex, int row, int col) {
    if (isOpen(row, col)) {
      int neighbour = getFieldIndex(row, col);

      union.union(fieldIndex, neighbour);

      // connect this with blue dot network if this neighbour is full
      blueDotNetwork.union(fieldIndex, neighbour);
    }
  }

  private enum Directions {
    LEFT(-1, 0), RIGHT(1, 0), UP(0, 1), DOWN(0, -1);

    private int x;
    private int y;

    Directions(int x, int y) {
      this.x = x;
      this.y = y;
    }

    public int getX() {
      return x;
    }

    public int getY() {
      return y;
    }
  }
}
