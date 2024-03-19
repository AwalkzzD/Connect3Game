package com.example.connect3game.ui.home.welcome;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.lifecycle.ViewModelProvider;

import com.example.connect3game.R;
import com.example.connect3game.ui.home.GameViewModel;
import com.example.connect3game.ui.home.game.GameFragment;

public class WelcomeFragment extends Fragment {

    private GameViewModel gameViewModel;

    private FragmentManager fragmentManager;

    private String playerOneName;
    private String playerTwoName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_welcome, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initViewModel();

        fragmentManager = requireActivity().getSupportFragmentManager();

        EditText playerOneET = view.findViewById(R.id.player_one_name);
        EditText playerTwoET = view.findViewById(R.id.player_two_name);

        Button playButton = view.findViewById(R.id.play_button);

        playButton.setOnClickListener(v -> {
            playerOneName = playerOneET.getText().toString();
            playerTwoName = playerTwoET.getText().toString();
            if (!playerOneName.isEmpty() && !playerTwoName.isEmpty()) {
                gameViewModel.setPlayers(playerOneName, playerTwoName);
                fragmentManager.beginTransaction().replace(R.id.nav_host_fragment_container, new GameFragment()).commit();
            } else {
                Toast.makeText(getActivity(), "Name cannot be empty", Toast.LENGTH_LONG).show();
            }
        });

    }

    /**
     * viewModel initialization for setting players.
     */
    private void initViewModel() {
        gameViewModel = new ViewModelProvider(requireActivity()).get(GameViewModel.class);
    }
}