package com.example.soccermanager.data.iterators;

import com.example.soccermanager.data.models.Team;

import java.util.Iterator;
import java.util.List;

public class TeamCollection implements Iterable<Team> {
    private final List<Team> teams;

    public TeamCollection(List<Team> teams) {
        this.teams = teams;
    }

    @Override
    public Iterator<Team> iterator() {
        return new TeamIterator(teams);
    }
}