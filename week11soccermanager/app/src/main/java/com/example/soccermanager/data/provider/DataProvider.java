package com.example.soccermanager.data.provider;

import com.example.soccermanager.data.models.SoccerEntity;
import com.example.soccermanager.data.repository.Repository;

import java.util.List;

public class DataProvider<T extends SoccerEntity> {

    private final Repository<T> repository;

    public DataProvider(List<T> initialData) {
        this.repository = new Repository<>();
        if (initialData != null) {
            initialData.forEach(repository::add);
        }
    }

    public Repository<T> getRepository() {
        return repository;
    }
}