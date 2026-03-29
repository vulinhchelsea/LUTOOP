package com.example.soccermanager;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import com.example.soccermanager.data.models.Match;
import com.example.soccermanager.data.models.Player;
import com.example.soccermanager.data.models.Team;
import com.example.soccermanager.data.provider.DataProvider;
import com.example.soccermanager.data.provider.SampleDataFactory;
import com.example.soccermanager.data.repository.Repository;
import com.example.soccermanager.ui.MainPagerAdapter;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {

    private Repository<Team> teamRepository;
    private Repository<Player> playerRepository;
    private Repository<Match> matchRepository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initRepositories();

        ViewPager2 viewPager = findViewById(R.id.viewPager);
        TabLayout tabLayout = findViewById(R.id.tabLayout);

        MainPagerAdapter adapter = new MainPagerAdapter(
                this,
                teamRepository,
                playerRepository,
                matchRepository
        );

        viewPager.setAdapter(adapter);

        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    if (position == 0) tab.setText("Teams");
                    else if (position == 1) tab.setText("Players");
                    else tab.setText("Matches");
                }).attach();
    }

    private void initRepositories() {
        teamRepository = new DataProvider<>(SampleDataFactory.createSampleTeams()).getRepository();
        playerRepository = new DataProvider<>(SampleDataFactory.createSamplePlayers()).getRepository();
        matchRepository = new DataProvider<>(SampleDataFactory.createSampleMatches()).getRepository();
    }
}