package com.example.connect3game;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

public class GameFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_game, container, false);

        Toolbar toolbar = view.findViewById(R.id.custom_toolbar);
        AppCompatActivity activity = (AppCompatActivity) getActivity();
        if (activity != null) {
            activity.setSupportActionBar(toolbar);
        }

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button a1 = view.findViewById(R.id.a1);
        a1.setText("X");

    }
}