package com.example.connect3game.ui.home;

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.connect3game.data.GameBoard;
import com.example.connect3game.data.Player;

public class GameViewModel extends ViewModel {

    /**
     * Observable Fields for updating UI on data change automatically.
     */
    public ObservableField<String> currentPlayer = new ObservableField<>();
    public ObservableArrayMap<String, Player> cells;

    public GameBoard game;
    public Player player1, player2;
    public Boolean gameRunning;

    /**
     * setPlayers method for setting players.
     */
    public void setPlayers(String playerOneName, String playerTwoName) {
        player1 = new Player(playerOneName, "X");
        player2 = new Player(playerTwoName, "O");
    }

    /**
     * setGameBoard method for setting game board and resetting it.
     */
    public void setGameBoard() {
        game = new GameBoard(player1, player2);
        cells = new ObservableArrayMap<>();
        gameRunning = true;
        currentPlayer.set(game.currentPlayer.name + "'s Turn");
    }

    /**
     * onCellClick method for updating changes in model class and update UI accordingly.
     */
    public void onCellClick(String key) {
        if (gameRunning) {
            int row = Integer.parseInt(String.valueOf(key.charAt(0)));
            int column = Integer.parseInt(String.valueOf(key.charAt(1)));
            if (game.cells[row][column] == null) {
                cells.put(key, game.currentPlayer);
                game.addPlayerCell(row, column);
                currentPlayer.set("Play a Move " + game.currentPlayer.name);
            }
        }
    }

    /**
     * clearCells method for resetting board.
     */
    public void clearCells() {
        cells.clear();
    }

    public LiveData<Player> getWinner() {
        return game.winner;
    }

}
