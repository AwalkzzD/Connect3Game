package com.example.connect3game.ui.home;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.connect3game.R;
import com.example.connect3game.ui.home.welcome.WelcomeFragment;

public class GameActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        /**
         * FragmentManager for navigation of pages.
         * */
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().add(R.id.nav_host_fragment_container, new WelcomeFragment()).commit();
    }
}