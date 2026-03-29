package com.example.soccermanager.data.iterators;

import com.example.soccermanager.data.models.Player;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class PlayerIterator implements Iterator<Player> {

    private final List<Player> players;
    private int index = 0;

    public PlayerIterator(List<Player> players) {
        this.players = players != null ? players : Collections.emptyList();
    }

    @Override
    public boolean hasNext() {
        return index < players.size();
    }

    @Override
    public Player next() {
        if (!hasNext()) throw new NoSuchElementException("No more players");
        return players.get(index++);
    }
}