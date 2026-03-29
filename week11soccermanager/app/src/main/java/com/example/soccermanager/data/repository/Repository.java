package com.example.soccermanager.data.repository;

import com.example.soccermanager.data.models.SoccerEntity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Repository<T extends SoccerEntity> implements Iterable<T> {

    private final List<T> items = new ArrayList<>();

    public void add(T item) {
        if (item == null) throw new IllegalArgumentException("Item cannot be null");
        // simple duplicate check by id
        if (items.stream().anyMatch(i -> i.getId() == item.getId())) {
            throw new IllegalStateException("Item with same id already exists");
        }
        items.add(item);
    }

    public Optional<T> getById(long id) {
        return items.stream().filter(i -> i.getId() == id).findFirst();
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(items);
    }

    // generic filter using lambda
    public List<T> filter(Predicate<T> predicate) {
        if (predicate == null) throw new IllegalArgumentException("Predicate cannot be null");
        return items.stream().filter(predicate).collect(Collectors.toList());
    }

    // generic sort using lambda comparator
    public List<T> sort(Comparator<T> comparator) {
        if (comparator == null) throw new IllegalArgumentException("Comparator cannot be null");
        return items.stream().sorted(comparator).collect(Collectors.toList());
    }

    @Override
    public Iterator<T> iterator() {
        return items.iterator();
    }
}