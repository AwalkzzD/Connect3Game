package com.example.connect3game.data;

import androidx.annotation.Nullable;

public class Player {

    public String name;
    public String value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }


    /**
     * override equals method for custom implementation of comparing players
     */
    @Override
    public boolean equals(@Nullable Object obj) {

        if (this == obj) return true;

        Player player = (Player) obj;

        return name.compareTo(player.name) == 0 && value.compareTo(player.value) == 0;

    }
}
