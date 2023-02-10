import java.util.Scanner;

public class TicTacToe {
    static Scanner sc = new Scanner(System.in);
    static char[][] board = {{' ', ' ', ' '}, {' ', ' ', ' '}, {' ', ' ', ' '}};
    static int turn = 0;

    public static void main(String[] args) {
        while (true) {
            printBoard();
            getInput();
            if (checkWin('X')) {
                System.out.println("Player X wins!");
                break;
            } else if (checkWin('O')) {
                System.out.println("Player O wins!");
                break;
            } else if (turn == 9) {
                System.out.println("It's a tie!");
                break;
            }
            turn++;
        }
    }

    static void getInput() {
        System.out.print("Enter row and column");
        int row = sc.nextInt() - 1;
        int col = sc.nextInt() - 1;
        while (board[row][col] != ' ') {
            System.out.println("Space already occupied. Try again.");
            System.out.print("Enter row and column");
            row = sc.nextInt() - 1;
            col = sc.nextInt() - 1;
        }
        board[row][col] = turn % 2 == 0 ? 'X' : 'O';
    }

    static boolean checkWin(char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }

    static void printBoard() {
        System.out.println(" " + board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("---+---+---");
        System.out.println(" " + board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
    }
}