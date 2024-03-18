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
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.connect3game.R;
import com.example.connect3game.databinding.FragmentGameBinding;
import com.example.connect3game.models.GameBoard;
import com.example.connect3game.models.Player;
import com.example.connect3game.viewmodels.GameViewModel;
import com.example.connect3game.views.home.welcome.WelcomeFragment;

public class GameFragment extends Fragment {

    private GameViewModel gameViewModel;

    private FragmentManager fragmentManager;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        FragmentGameBinding gameBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_game, container, false);
        gameViewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
        initViewModel();

        gameBinding.setViewModel(gameViewModel);

        Toolbar toolbar = gameBinding.customToolbar;
        AppCompatActivity activity = (AppCompatActivity) getActivity();

        if (activity != null) activity.setSupportActionBar(toolbar);

        return gameBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        fragmentManager = requireActivity().getSupportFragmentManager();

        Button quitGame = view.findViewById(R.id.quit_game_button);
        Button playAgain = view.findViewById(R.id.play_again_button);

        quitGame.setOnClickListener(v -> fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, new WelcomeFragment()).commit());

        playAgain.setOnClickListener(v -> {
            gameViewModel.clearCells();
            initViewModel();
        });

    }

    private void initViewModel() {
        gameViewModel.setGameBoard();
        gameViewModel.getWinner().observe(getViewLifecycleOwner(), this::checkWinner);
    }

    private void checkWinner(Player winner) {
        if (winner.equals(GameBoard.NO_ONE)) {
            gameViewModel.currentPlayer.set("It's a Draw!");
            gameViewModel.gameRunning = false;
        } else if (winner.equals(gameViewModel.player1)) {
            gameViewModel.currentPlayer.set(winner.name + " has Won!" + "\nCongratulations!!!");
            gameViewModel.gameRunning = false;
        } else if (winner.equals(gameViewModel.player2)) {
            gameViewModel.currentPlayer.set(winner.name + " has Won!" + "\nCongratulations!!!");
            gameViewModel.gameRunning = false;
        }
    }

}