package com.example.connect3game.views.home.game;

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
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.connect3game.R;
import com.example.connect3game.viewmodels.GameViewModel;
import com.example.connect3game.views.home.welcome.WelcomeFragment;

import java.util.ArrayList;

public class GameFragment extends Fragment {

    private GameViewModel gameViewModel;
    private FragmentManager fragmentManager;

    private ArrayList<Button> buttons = new ArrayList<>();

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

        initViewModel();

        fragmentManager = requireActivity().getSupportFragmentManager();

        Button quitGame = view.findViewById(R.id.quit_game_button);
        Button playAgain = view.findViewById(R.id.play_again_button);

        quitGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, new WelcomeFragment()).commit();
            }
        });

        playAgain.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gameViewModel.resetBoard();
            }
        });

    }

    private void initViewModel() {
        gameViewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
    }
}