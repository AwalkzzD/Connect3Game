package com.example.connect3game.viewmodels;

import androidx.databinding.ObservableArrayMap;
import androidx.databinding.ObservableField;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.connect3game.models.GameBoard;
import com.example.connect3game.models.Player;

public class GameViewModel extends ViewModel {

    public ObservableField<String> currentPlayer = new ObservableField<>();
    public ObservableArrayMap<String, Player> cells;

    public GameBoard game;
    public Player player1, player2;
    public Boolean gameRunning;

    public void setPlayers(String playerOneName, String playerTwoName) {
        player1 = new Player(playerOneName, "X");
        player2 = new Player(playerTwoName, "O");
    }

    public void setGameBoard() {
        game = new GameBoard(player1, player2);
        cells = new ObservableArrayMap<>();
        gameRunning = true;
        currentPlayer.set(game.currentPlayer.name + "'s Turn");
    }

    public void onCellClick(String key) {
        if (gameRunning) {
            int row = Integer.parseInt(String.valueOf(key.charAt(0)));
            int column = Integer.parseInt(String.valueOf(key.charAt(1)));
            if (game.cells[row][column] == null) {
                cells.put(key, game.currentPlayer);
                game.addPlayerCell(row, column);
                currentPlayer.set(game.currentPlayer.name + "'s Turn");
            }
        }
    }

    public void clearCells() {
        cells.clear();
    }

    public LiveData<Player> getWinner() {
        return game.winner;
    }

}
