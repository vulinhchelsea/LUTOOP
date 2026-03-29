package com.example.soccermanager.data.iterators;

import com.example.soccermanager.data.models.Team;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class TeamIterator implements Iterator<Team> {

    private final List<Team> teams;
    private int index = 0;

    public TeamIterator(List<Team> teams) {
        this.teams = teams != null ? teams : Collections.emptyList();
    }

    @Override
    public boolean hasNext() {
        return index < teams.size();
    }

    @Override
    public Team next() {
        if (!hasNext()) throw new NoSuchElementException("No more teams");
        return teams.get(index++);
    }
}