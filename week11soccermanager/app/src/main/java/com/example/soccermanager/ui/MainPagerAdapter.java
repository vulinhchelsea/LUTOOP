package com.example.soccermanager.ui;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.soccermanager.data.models.Match;
import com.example.soccermanager.data.models.Player;
import com.example.soccermanager.data.models.Team;
import com.example.soccermanager.data.repository.Repository;
import com.example.soccermanager.ui.matches.MatchesFragment;
import com.example.soccermanager.ui.players.PlayersFragment;
import com.example.soccermanager.ui.teams.TeamsFragment;

public class MainPagerAdapter extends FragmentStateAdapter {

    private final Repository<Team> teamRepo;
    private final Repository<Player> playerRepo;
    private final Repository<Match> matchRepo;

    public MainPagerAdapter(
            @NonNull FragmentActivity activity,
            Repository<Team> teamRepo,
            Repository<Player> playerRepo,
            Repository<Match> matchRepo
    ) {
        super(activity);
        this.teamRepo = teamRepo;
        this.playerRepo = playerRepo;
        this.matchRepo = matchRepo;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0) return TeamsFragment.newInstance(teamRepo);
        if (position == 1) return PlayersFragment.newInstance(playerRepo);
        return MatchesFragment.newInstance(matchRepo);
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}