package in.shabhushan.cp_trials.string.logic;

import java.awt.*;
import java.util.Arrays;

public class Boggle {
  final static private Point[] MOVES = {new Point(-1,-1), new Point(-1,0), new Point(-1,1),
      new Point( 0,-1),                  new Point( 0,1),
      new Point( 1,-1), new Point( 1,0), new Point( 1,1)};

  private char[][] board;
  private char[] word;

  public Boggle(final char[][] board, final String word) {
    // Your code here!
    this.board = board;
    this.word = word.toCharArray();
  }

  public boolean check() {
    // Your code here too!
    for (int row = 0; row < board.length; row++) {
      for (int column = 0; column < board[row].length; column++) {
        if (board[row][column] == word[0]) {
          if (found(1, new Point(row, column)))
            return true;
        }
      }
    }
    return false;
  }

  private boolean found(final int c, final Point p) {
    if (c == word.length)
      return true;

    char previousChar = board[p.x][p.y];
    board[p.x][p.y] = '-';

    boolean b = Arrays.stream(MOVES).map(move -> new Point(p.x + move.x, p.y + move.y))
        .filter(point -> isWithinBounds(point, 0, board.length) && word[c] == board[point.x][point.y])
        .anyMatch(m -> found(c + 1, m));

    board[p.x][p.y] = previousChar;
    return b;
  }

  private static boolean isWithinBounds(Point point, int lowerBound, int upperBound) {
    return lowerBound <= point.x && point.x < upperBound && lowerBound <= point.y && point.y < upperBound;
  }
}
