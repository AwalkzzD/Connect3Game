package com.example.connect3game.viewmodels;

import androidx.lifecycle.ViewModel;

import com.example.connect3game.models.GameBoard;
import com.example.connect3game.models.Player;

public class GameViewModel extends ViewModel {

    private Player playerOne;
    private Player playerTwo;
    private Player currentPlayer;

    private int totalMoves = 0;

    private GameBoard gameBoard = new GameBoard();

    public void setPlayers(String playerOneName, String playerTwoName) {
        this.playerOne = new Player(playerOneName, "X");
        this.playerTwo = new Player(playerTwoName, "O");
    }

    public Player getCurrentPlayer() {
        if (totalMoves <= 9) {
            if (totalMoves % 2 == 1) {
                currentPlayer = playerOne;
            } else {
                currentPlayer = playerTwo;
            }
        }
        return currentPlayer;
    }

    public void playMove(int row, int col) {
        totalMoves++;
        gameBoard.setMove(row, col, getCurrentPlayer().getPlayerSymbol());
    }

    public boolean isGameOver() {
        return (checkWinner(playerOne.getPlayerSymbol()) || checkWinner(playerTwo.getPlayerSymbol()) || isBoardFull());
    }

    private boolean isBoardFull() {
        if (totalMoves == 9) {
            return true;
        }
        return false;
    }

    private boolean checkWinner(String symbol) {
        String[][] cells = gameBoard.getBoard();

        for (int i = 0; i < 3; i++) {
            if ((cells[i][0].equals(symbol) && cells[i][1].equals(symbol) && cells[i][2].equals(symbol)) || (cells[0][i].equals(symbol) && cells[1][i].equals(symbol) && cells[2][i].equals(symbol))) {
                return true;
            }
        }

        return (cells[0][0].equals(symbol) && cells[1][1].equals(symbol) && cells[2][2].equals(symbol)) || (cells[0][2].equals(symbol) && cells[1][1].equals(symbol) && cells[2][0].equals(symbol));
    }

    public void resetBoard() {
        gameBoard.reset();
        totalMoves = 0;
        playerOne = null;
        playerTwo = null;
        currentPlayer = null;
    }

}
