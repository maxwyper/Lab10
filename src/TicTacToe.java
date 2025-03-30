import java.util.Scanner;

public class TicTacToe {
    private static final int ROWS = 3;
    private static final int COLS = 3;
    private static String[][] board = new String[ROWS][COLS];

    public static void main(String[] args) {
        Scanner console = new Scanner(System.in);
        boolean playAgain = true;


        while (playAgain) {
            clearBoard();
            String currentPlayer = "X";
            int moveCount = 0;


            while (true) {
                display();

                int rowMove = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, 3) - 1;
                int colMove = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, 3) - 1;


                while (!isValidMove(rowMove, colMove)) {
                    System.out.println("Invalid move. Try again.");
                    rowMove = SafeInput.getRangedInt(console, "Enter row (1-3): ", 1, 3) - 1;
                    colMove = SafeInput.getRangedInt(console, "Enter column (1-3): ", 1, 3) - 1;
                }


                board[rowMove][colMove] = currentPlayer;
                moveCount++;


                if (isWin(currentPlayer)) {
                    display();
                    System.out.println("Player " + currentPlayer + " wins!");
                    break;
                }

                if (isTie()) {
                    display();
                    System.out.println("It's a tie!");
                    break;
                }


                currentPlayer = (currentPlayer.equals("X")) ? "O" : "X";
            }


            playAgain = SafeInput.getYNConfirm(console, "Do you want to play again? (y/n): ");
        }
    }


    private static void clearBoard() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                board[i][j] = " ";  // Empty space
            }
        }
    }


    private static void display() {
        System.out.println();
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                System.out.print(" " + board[i][j] + " ");
                if (j < COLS - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < ROWS - 1) {
                System.out.println("---|---|---");
            }
        }
        System.out.println();
    }


    private static boolean isValidMove(int row, int col) {
        return board[row][col].equals(" ");
    }


    private static boolean isWin(String player) {
        return isRowWin(player) || isColWin(player) || isDiagnalWin(player);
    }


    private static boolean isRowWin(String player) {
        for (int i = 0; i < ROWS; i++) {
            if (board[i][0].equals(player) && board[i][1].equals(player) && board[i][2].equals(player)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isColWin(String player) {
        for (int i = 0; i < COLS; i++) {
            if (board[0][i].equals(player) && board[1][i].equals(player) && board[2][i].equals(player)) {
                return true;
            }
        }
        return false;
    }


    private static boolean isDiagnalWin(String player) {
        return (board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)) ||
                (board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player));
    }


    private static boolean isTie() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                if (board[i][j].equals(" ")) {
                    return false; // There's still space, so no tie
                }
            }
        }
        return true; // All spaces are filled, so it's a tie
    }
}

