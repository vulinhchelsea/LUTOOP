package com.example.soccermanager.ui.matches;

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
import com.example.soccermanager.data.models.Match;
import com.example.soccermanager.data.repository.Repository;
import com.example.soccermanager.ui.adapters.MatchAdapter;

import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class MatchesFragment extends Fragment {

    private Repository<Match> matchRepository;
    private MatchAdapter adapter;

    public static MatchesFragment newInstance(Repository<Match> repo) {
        MatchesFragment fragment = new MatchesFragment();
        fragment.matchRepository = repo;
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_matches, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        adapter = new MatchAdapter(match ->
                Toast.makeText(getContext(), "Clicked match", Toast.LENGTH_SHORT).show()
        );

        RecyclerView recyclerView = view.findViewById(R.id.recyclerViewMatches);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);

        adapter.submitList(matchRepository.getAll());

        EditText search = view.findViewById(R.id.searchBarMatches);
        search.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String q = s.toString().toLowerCase(Locale.ROOT);
                List<Match> filtered = matchRepository.filter(
                        m -> m.getHomeTeam().toLowerCase(Locale.ROOT).contains(q)
                                || m.getAwayTeam().toLowerCase(Locale.ROOT).contains(q)
                );
                adapter.submitList(filtered);
            }
            @Override public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override public void afterTextChanged(Editable s) {}
        });

        Button sortDate = view.findViewById(R.id.sortByDate);
        Button sortHome = view.findViewById(R.id.sortByHomeTeam);

        sortDate.setOnClickListener(v -> {
            adapter.submitList(matchRepository.sort(
                    Comparator.comparing(Match::getDate)
            ));
        });

        sortHome.setOnClickListener(v -> {
            adapter.submitList(matchRepository.sort(
                    Comparator.comparing(Match::getHomeTeam)
            ));
        });
    }
}