package com.example.connect3game.models;

import androidx.annotation.Nullable;

public class Player {

    public String name;
    public String value;
//    public Drawable value;

    public Player(String name, String value) {
        this.name = name;
        this.value = value;
    }

    @Override
    public boolean equals(@Nullable Object obj) {

        if (this == obj) return true;

        Player player = (Player) obj;

        return name.compareTo(player.name) == 0 && value.compareTo(player.value) == 0;
//        return name.compareTo(player.name) == 0 && value.equals(player.value);

    }
}
