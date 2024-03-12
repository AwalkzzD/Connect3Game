package com.example.connect3game;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_container, new WelcomeFragment()).commit();
    }
}