package com.example.connect3game.data;

import androidx.lifecycle.MutableLiveData;

public class GameBoard {

    public static final int WIDTH_SIZE = 3;
    public static final int HEIGHT_SIZE = 3;
    public static final Player NO_ONE = new Player("No One", "-");

    public Cell[][] cells;
    public Player currentPlayer;
    Player player1;
    Player player2;
    public MutableLiveData<Player> winner;
    int remainder;

    public GameBoard(Player player1, Player player2) {
        init(player1, player2);
    }

    /**
     * init method to initialize and reset game board.
     */
    private void init(Player player1, Player player2) {
        cells = new Cell[WIDTH_SIZE][HEIGHT_SIZE];
        this.player1 = player1;
        this.player2 = player2;
        currentPlayer = this.player1;
        remainder = WIDTH_SIZE * HEIGHT_SIZE;
        winner = new MutableLiveData<>();
    }

    /**
     * winnerCheck method to compare cell value.
     */
    public boolean winnerCheck(Cell... cells) {
        if (cells[0] == null || cells[1] == null || cells[2] == null) return false;
        return cells[0].player.value.compareTo(cells[1].player.value) == 0 && (cells[1].player.value.compareTo(cells[2].player.value) == 0);
    }

    /**
     * verticalWinner method to check Vertical cells of GameBoard.
     */
    public boolean verticalWinner() {
        Cell[] checkCell = new Cell[WIDTH_SIZE];
        for (int j = 0; j < HEIGHT_SIZE; j++) {
            checkCell[0] = cells[0][j];
            checkCell[1] = cells[1][j];
            checkCell[2] = cells[2][j];
            if (winnerCheck(checkCell)) return true;
        }
        return false;
    }

    /**
     * horizontalWinner method to check Horizontal cells of GameBoard.
     */
    public boolean horizontalWinner() {
        for (Cell[] c : cells)
            if (winnerCheck(c)) return true;
        return false;
    }

    /**
     * diagonalWinner method to check Diagonal cells of GameBoard.
     */
    public boolean diagonalWinner() {
        Cell[] checkCell = new Cell[WIDTH_SIZE];
        checkCell[0] = cells[0][0];
        checkCell[1] = cells[1][1];
        checkCell[2] = cells[2][2];
        if (winnerCheck(checkCell)) return true;
        checkCell[0] = cells[0][2];
        checkCell[1] = cells[1][1];
        checkCell[2] = cells[2][0];
        return winnerCheck(checkCell);
    }

    /**
     * method to add player's move in the board.
     */
    public void addPlayerCell(int row, int column) {
        cells[row][column] = new Cell(currentPlayer);
        remainder -= 1;
        if (verticalWinner()) {
            winner.postValue(currentPlayer);
            return;
        } else if (horizontalWinner()) {
            winner.postValue(currentPlayer);
            return;
        } else if (diagonalWinner()) {
            winner.postValue(currentPlayer);
            return;
        } else if (remainder == 0) {
            winner.postValue(NO_ONE);
            return;
        }
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
