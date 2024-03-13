package com.example.connect3game.models;

public class GameBoard {
    private String[][] board;

    public GameBoard() {
        board = new String[3][3];
        reset();
    }

    public void reset() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; i++) {
                board[i][j] = "";
            }
        }
    }

    public String[][] getBoard() {
        return board;
    }

    public String getMove(int row, int col) {
        return board[row][col];
    }

    public void setMove(int row, int col, String symbol) {
        board[row][col] = symbol;
    }
}
