package com.example.soccermanager.ui.players;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccermanager.R;
import com.example.soccermanager.data.models.Player;
import com.example.soccermanager.data.repository.Repository;
import com.example.soccermanager.ui.adapters.PlayerAdapter;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class PlayersFragment extends Fragment {

    private Repository<Player> playerRepository;
    private PlayerAdapter adapter;

    public static PlayersFragment newInstance(Repository<Player> repo) {
        PlayersFragment fragment = new PlayersFragment();
        fragment.playerRepository = repo;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_players, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new PlayerAdapter(player ->
                Toast.makeText(getContext(), "Clicked: " + player.getName(), Toast.LENGTH_SHORT).show()
        );

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewPlayers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.submitList(playerRepository.getAll());

        EditText search = view.findViewById(R.id.searchBarPlayers);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString().toLowerCase(Locale.ROOT);
                List<Player> filtered = playerRepository.filter(
                        p -> p.getName().toLowerCase(Locale.ROOT).contains(q)
                );
                adapter.submitList(filtered);
            }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        Button sortName = view.findViewById(R.id.sortByPlayerName);
        Button sortAge = view.findViewById(R.id.sortByPlayerAge);

        sortName.setOnClickListener(v -> {
            adapter.submitList(playerRepository.sort(
                    Comparator.comparing(Player::getName)
            ));
        });

        sortAge.setOnClickListener(v -> {
            adapter.submitList(playerRepository.sort(
                    Comparator.comparingInt(Player::getAge)
            ));
        });
    }
}