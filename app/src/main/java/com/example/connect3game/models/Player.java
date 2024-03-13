package com.example.connect3game.models;

public class Player {
    private String playerName;
    private String playerSymbol;

    public Player(String name, String symbol) {
        this.playerName = name;
        this.playerSymbol = symbol;
    }

    public String getPlayerSymbol() {
        return playerSymbol;
    }

    public String getPlayerName() {
        return playerName;
    }
}
