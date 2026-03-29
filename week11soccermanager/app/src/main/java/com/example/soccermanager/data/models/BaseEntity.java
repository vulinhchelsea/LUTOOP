package com.example.soccermanager.data.models;

public abstract class BaseEntity implements SoccerEntity {
    private final long id;

    protected BaseEntity(long id) {
        if (id <= 0) throw new IllegalArgumentException("Id must be positive");
        this.id = id;
    }

    @Override
    public long getId() {
        return id;
    }
}