package in.shabhushan.cp_trials.backtracking;

public class NQueen {
  private static final int OCCUPIED = 1;
  private static final int NOT_OCCUPIED = 0;

  public static boolean isSolvable(int N) {
    int[][] board = new int[N][N];

    return isSolvable(board, 0);
  }

  private static boolean isSolvable(int[][] board, int row) {
    if (row == board.length)
      return true;

    for (int col = 0; col < board[row].length; col++) {
      if (isPositionSafe(board, row, col)) {
        board[row][col] = OCCUPIED;

        if (isSolvable(board, row + 1)) {
          return true;
        }

        board[row][col] = NOT_OCCUPIED;
      }
    }

    return false;
  }

  private static boolean isPositionSafe(int[][] board, int row, int col) {
    if (row < 0 || board.length <= row && col < 0 || board[row].length <= col || board[row][col] == OCCUPIED)
      return false;

    for (int i = row - 1; i >= 0; i--) {
      if (board[i][col] == OCCUPIED)
        return false;
    }

    // left diagonal
    for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
      if (board[i][j] == OCCUPIED)
        return false;
    }

    for (int i = row -1, j = col + 1; i >= 0 && j < board[row].length; i--,j++) {
      if (board[i][j] == OCCUPIED)
        return false;
    }

    return true;
  }
}
