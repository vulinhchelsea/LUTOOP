package com.example.soccermanager.ui.teams;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
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
import com.example.soccermanager.data.iterators.TeamCollection;
import com.example.soccermanager.data.models.Team;
import com.example.soccermanager.data.repository.Repository;
import com.example.soccermanager.ui.adapters.TeamAdapter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class TeamsFragment extends Fragment {

    private Repository<Team> teamRepository;
    private List<Team> currentList = new ArrayList<>();
    private TeamAdapter adapter;

    public static TeamsFragment newInstance(Repository<Team> repo) {
        TeamsFragment fragment = new TeamsFragment();
        fragment.teamRepository = repo;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_teams, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Setup adapter with lambda click handler
        adapter = new TeamAdapter(team ->
                Toast.makeText(getContext(), "Clicked: " + team.getName(), Toast.LENGTH_SHORT).show()
        );

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewTeams);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        // Initial list
        currentList = teamRepository.getAll();
        adapter.submitList(currentList);

        // Search bar
        EditText searchBar = view.findViewById(R.id.searchBar);
        setupSearch(searchBar);

        // Sorting buttons
        Button sortByName = view.findViewById(R.id.sortByName);
        Button sortByYear = view.findViewById(R.id.sortByYear);

        sortByName.setOnClickListener(v -> {
            List<Team> sorted = teamRepository.sort(
                    (a, b) -> a.getName().compareToIgnoreCase(b.getName())
            );
            adapter.submitList(sorted);
        });

        sortByYear.setOnClickListener(v -> {
            List<Team> sorted = teamRepository.sort(
                    Comparator.comparingInt(Team::getFoundedYear)
            );
            adapter.submitList(sorted);
        });

        // Streams transformation demo
        List<String> teamNames = teamRepository.getAll().stream()
                .map(Team::getName)
                .sorted()
                .toList();

        Log.d("StreamsDemo", "Team names: " + teamNames);

        // Custom iterator demo
        TeamCollection teamCollection = new TeamCollection(teamRepository.getAll());
        for (Team t : teamCollection) {
            Log.d("IteratorDemo", "Team: " + t.getName());
        }
    }

    private void setupSearch(EditText searchBar) {
        searchBar.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String query = s.toString().toLowerCase(Locale.ROOT);

                currentList = teamRepository.filter(
                        team -> team.getName().toLowerCase(Locale.ROOT).contains(query)
                );

                adapter.submitList(currentList);
            }

            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });
    }
}