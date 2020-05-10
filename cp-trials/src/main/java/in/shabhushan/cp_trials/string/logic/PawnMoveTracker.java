package in.shabhushan.cp_trials.string.logic;

import java.util.stream.IntStream;
import java.util.stream.Stream;

class PawnMoveTracker {

  private static final int POINT_A = Character.getNumericValue('a');

  private static final byte EMPTY = 0;
  private static final byte WHITE = 1;
  private static final byte BLACK = 2;

  private static int toMatrixColumn(char column) {
    return Character.getNumericValue(column) - POINT_A;
  }

  private static int toMatrixRow(char row) {
    return 8 - Integer.parseInt(String.valueOf(row));
  }

  private static boolean isInRange(int coordinate) {
    return 0 <= coordinate && coordinate < 8;
  }

  private static boolean isKillMove(String move) {
    return move.length() == 4;
  }

  private static boolean isInitialMoveOfPawn(String move, byte nextPositionValue, int initialRow, byte turn) {
    return !isKillMove(move) && nextPositionValue == EMPTY && initialRow == (turn == WHITE ? 5 : 2);
  }

  /**
   * Make an Initial byte array
   * 0 is EMPTY
   * @param moves
   * @return
   */
  public static String[][] movePawns(String[] moves) {
    byte[][] board = {
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        // Initial Black Pawns
        {BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK, BLACK},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
        // Initial White Pawns
        {WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE, WHITE},
        {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY}
    };

    byte currentPlayer = WHITE;
    byte nextPlayer;

    String invalidMove = null;
    for (String move: moves) {
      nextPlayer = (currentPlayer == WHITE) ? BLACK : WHITE;

      int finalRow = toMatrixRow(move.charAt(move.length() - 1));
      int finalColumn = toMatrixColumn(move.charAt(move.length() - 2));

      // if kill move, there should be opposite pawn on this location, else empty
      if (board[finalRow][finalColumn] != (isKillMove(move) ? nextPlayer : EMPTY)) {
        invalidMove = move;
        break;
      }

      int initialRow = (currentPlayer == WHITE) ? finalRow + 1 : finalRow - 1;
      int initialColumn = isKillMove(move) ? toMatrixColumn(move.charAt(0)) : finalColumn;

      if (!isInRange(initialRow)) {
        invalidMove = move;
        break;
      }

      if (board[initialRow][initialColumn] == currentPlayer) {
        board[finalRow][finalColumn] = currentPlayer;
        board[initialRow][initialColumn] = EMPTY;
      } else if(isInitialMoveOfPawn(move, board[initialRow][initialColumn], initialRow, currentPlayer)) {
        // Checking if it's pawn's initial double move
        initialRow = (currentPlayer == WHITE) ? 6 : 1;

        if (board[initialRow][initialColumn] == currentPlayer) {
          board[finalRow][finalColumn] = currentPlayer;
          board[initialRow][initialColumn] = EMPTY;
        } else {
          invalidMove = move;
          break;
        }
      } else {
        invalidMove = move;
        break;
      }

      currentPlayer = nextPlayer;
    }

    return (invalidMove == null) ?
        Stream.of(board).map(row ->
          IntStream.range(0, row.length).mapToObj(num ->
            (row[num] == WHITE) ? "P" : (row[num] == BLACK ? "p" : ".")
          ).toArray(String[]::new)
        ).toArray(String[][]::new)
    : new String[][] { { invalidMove + " is invalid" } };
  }
}
