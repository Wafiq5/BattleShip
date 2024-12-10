import java.util.Scanner;

public class Board {
    public static String[][] emptyBoard(){
        String[][] temp = new String[10][10];

        for (int r = 0; r < temp.length; r++) {
            for (int c = 0; c < temp[r].length; c++) {
                temp[r][c] = "-";
            }
        }

        return temp;
    }
    public static String showBoard(String[][] board){
        String temp = "";

        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                temp += board[r][c] + " ";
            }
            temp += "\n";
        }

        return temp;
    }

    public static boolean addShip(String[][] boardParam, int rParam, int cParam, int lengthParam, int orinParam){
        for (int i = 0; i < lengthParam; i++) {
            if (orinParam == 0) {
                if (!boardParam[rParam + i][cParam].equals("-")) {
                    return false;
                }
            } else if (orinParam == 1) {
                if (!boardParam[rParam][cParam + i].equals("-")) {
                    return false;
                }
            }
        }
        for (int i = 0; i < lengthParam; i++) {
            if (orinParam == 0) {
                boardParam[rParam + i][cParam] = "o";
            } else if (orinParam == 1) {
                boardParam[rParam][cParam + i] = "o";
            }
        }
        return true;
    }
    public static void playGame(String[][] board1, String[][] board2, Scanner ask){
        boolean running = true;
        while (running){
            System.out.println("Player 1's turn! Guess row and column to attack.");
            System.out.println("Row: ");
            int r = Integer.valueOf(ask.nextLine());
            System.out.println("Column: ");
            int c = Integer.valueOf(ask.nextLine());

            if (board2[r][c].equals("o")){
                board2[r][c] = "x";
                System.out.println("Hit!");
            }
            else {
                System.out.println("Miss :(");
            }

            System.out.println("Player 2's turn. Enter row and column to attack:");
            r = Integer.valueOf(ask.nextLine());
            c = Integer.valueOf(ask.nextLine());
            if (board1[r][c].equals("o")) {
                board2[r][c] = "x";
                System.out.println("Hit!");
            } else {
                System.out.println("Miss :(");
            }
            if (gameOver(board1) || gameOver(board2)){
                running = false;
                System.out.println("- - - Game Over! - - -");
            }
        }
    }

    public static boolean gameOver(String[][] board){
        boolean gameOver = true;
        for (int r = 0; r < board.length; r++) {
            for (int c = 0; c < board[r].length; c++) {
                if (board[r][c].equals("o")){
                    gameOver = false;
                }
            }
        }
        return gameOver;
    }

}
