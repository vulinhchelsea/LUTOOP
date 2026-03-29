package com.example.soccermanager.data.models;

public class Player extends BaseEntity {
    private final String name;
    private final int age;
    private final String nationality;
    private final String position;
    private final String teamName;
    private final int shirtNumber;

    public Player(long id, String name, int age, String nationality,
                  String position, String teamName, int shirtNumber) {
        super(id);
        if (name == null || name.isBlank()) throw new IllegalArgumentException("Player name required");
        if (age <= 0) throw new IllegalArgumentException("Age must be positive");
        this.name = name;
        this.age = age;
        this.nationality = nationality;
        this.position = position;
        this.teamName = teamName;
        this.shirtNumber = shirtNumber;
    }

    // getters

    // get ID inherited from Base

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getNationality(){
        return nationality;
    }

    public String getPosition(){
        return position;
    }

    public String getTeamName(){
        return teamName;
    }

    public int getShirtNumber(){
        return shirtNumber;
    }
}