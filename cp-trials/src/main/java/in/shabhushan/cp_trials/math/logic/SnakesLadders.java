package in.shabhushan.cp_trials.math.logic;

public class SnakesLadders {
    private static int[] board = new int[]{
            0, 38 - 2, 0, 0, 0, 0, 14 - 7, 31 - 8, 0, 0, // 10
            0, 0, 0, 0, 26 - 15, 6 - 16, 0, 0, 0, 0, // 20
            42 - 21, 0, 0, 0, 0, 0, 0, 84 - 28, 0, 0, //30
            0, 0, 0, 0, 0, 44 - 36, 0, 0, 0, 0, // 40
            0, 0, 0, 0, 0, 25 - 46, 0, 0, 11 - 49, 0, // 50
            67 - 51, 0, 0, 0, 0, 0, 0, 0, 0, 0, // 60
            0, 19 - 62, 0, 60 - 64, 0, 0, 0, 0, 0, 0, // 70
            91 - 71, 0, 0, 53 - 74, 0, 0, 0,  98 - 78, 0, 0, // 80
            0, 0, 0, 0, 0, 0, 94 - 87, 0, 68 - 89, 0, // 90
            0, 88 - 92, 0, 0, 75 - 95, 0, 0, 0, 80 - 99, 0 // 100
    };

    private boolean firstPlayerTurn = true;
    private boolean gameOver = false;
    private int p1Position = -1;
    private int p2Position = -1;

    public SnakesLadders() {}

    public String play(int die1, int die2) {
        if (gameOver) {
            return "Game over!";
        }

        if (firstPlayerTurn) {
            p1Position += (die1 + die2);

            if (p1Position > 99) {
                p1Position = 198 - p1Position;
            }
            if (p1Position == 99) {
                gameOver = true;
                return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
            }
            if (board[p1Position] != 0) {
                p1Position += board[p1Position];
            }
        } else {
            p2Position += (die1 + die2);

            if (p2Position > 99) {
                p2Position = 198 - p2Position;
            }
            if (p2Position == 99) {
                gameOver = true;
                return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
            }

            if (board[p2Position] != 0) {
                p2Position += board[p2Position];
            }
        }

        String message = String.format("Player %d is on square %d", firstPlayerTurn ? 1 : 2, (firstPlayerTurn ? p1Position : p2Position) + 1);

        // Change player turn if dies are not equal
        if (die1 != die2) {
            firstPlayerTurn = !firstPlayerTurn;
        }

        return message;
    }

    public String play2(int die1, int die2) {
        if (firstPlayerTurn) {
            p1Position += die1;

            if (board[p1Position] != 0) {
                p1Position += p1Position + board[p1Position];
            } else {
                if (p1Position > 99) {
                    p1Position = 198 - p1Position;
                }
                if (p1Position == 99) {
                    return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
                }

                p1Position += die2;

                if (board[p1Position] != 0) {
                    p1Position += p1Position + board[p1Position];
                }
            }
            if (p1Position > 99) {
                p1Position = 198 - p1Position;
            }
            if (p1Position == 99) {
                return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
            }


        } else {
            p2Position += die1;

            if (board[p2Position] != 0) {
                p2Position += p2Position + board[p2Position];
            } else {
                if (p2Position > 99) {
                    p2Position = 198 - p2Position;
                }
                if (p2Position == 99) {
                    return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
                }

                p2Position += die2;

                if (board[p2Position] != 0) {
                    p2Position += p2Position + board[p2Position];
                }

            }
            if (p2Position > 99) {
                p2Position = 198 - p2Position;
            }
            if (p2Position == 99) {
                return String.format("Player %d Wins!", firstPlayerTurn ? 1 : 2);
            }
        }

        String message = String.format("Player %d is on square %d", firstPlayerTurn ? 1 : 2, firstPlayerTurn ? p1Position : p2Position);

        // Change player turn if dies are not equal
        if (die1 != die2) {
            firstPlayerTurn = !firstPlayerTurn;
        }

        return message;
    }
}
