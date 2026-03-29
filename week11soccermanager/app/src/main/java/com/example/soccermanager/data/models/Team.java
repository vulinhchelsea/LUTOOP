package com.example.soccermanager.data.models;

public class Team extends BaseEntity {
    private final String name;
    private final String country;
    private final String league;
    private final String stadium;
    private final int foundedYear;

    public Team(long id, String name, String country, String league, String stadium, int foundedYear) {
        super(id);
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Team name required");
        if (country == null || country.isBlank()) throw new IllegalArgumentException("Country required");
        this.name = name;
        this.country = country;
        this.league = league;
        this.stadium = stadium;
        this.foundedYear = foundedYear;
    }

    // getters

    // get ID inherited from Base

    public String getName(){
        return name;
    }

    public String getCountry(){
        return country;
    }

    public String getLeague(){
        return league;
    }

    public String getStadium(){
        return stadium;
    }

    public int getFoundedYear(){
        return foundedYear;
    }
}