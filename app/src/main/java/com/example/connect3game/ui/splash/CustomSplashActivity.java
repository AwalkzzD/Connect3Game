package com.example.connect3game.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

import com.example.connect3game.R;
import com.example.connect3game.ui.home.GameActivity;

public class CustomSplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_custom_splash);

        /**
         * Thread creation to display splash screen for 3000ms === 3 seconds
         * */
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(CustomSplashActivity.this, GameActivity.class));
                finish();
            }
        }, 3000);

    }
}