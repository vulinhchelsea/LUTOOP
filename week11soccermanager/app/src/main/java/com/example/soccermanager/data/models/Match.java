package com.example.soccermanager.data.models;

public class Match extends BaseEntity {
    private final String homeTeam;
    private final String awayTeam;
    private final String score;
    private final String competition;
    private final String date;    // could be LocalDate
    private final String stadium;

    public Match(long id, String homeTeam, String awayTeam, String score,
                 String competition, String date, String stadium) {
        super(id);
        if (homeTeam == null || homeTeam.isBlank()) throw new IllegalArgumentException("Home team required");
        if (awayTeam == null || awayTeam.isBlank()) throw new IllegalArgumentException("Away team required");
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
        this.competition = competition;
        this.date = date;
        this.stadium = stadium;
    }

    // getters...

    // get ID inherited from Base


    public String getHomeTeam() {
        return homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public String getScore(){
        return score;
    }

    public String getCompetition(){
        return competition;
    }

    public String getDate(){
        return date;
    }

    public String getStadium(){
        return stadium;
    }
}