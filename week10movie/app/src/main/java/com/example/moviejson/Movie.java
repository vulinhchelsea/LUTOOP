package com.example.moviejson;

public class Movie {
    private String title;
    private Integer year;          // use Integer so it can be null
    private String genre;
    private Integer posterResId;   // drawable resource id, can be null

    public Movie(String title, Integer year, String genre, Integer posterResId) {
        this.title = title;
        this.year = year;
        this.genre = genre;
        this.posterResId = posterResId;
    }

    // Getters
    public String getTitle() {
        return title != null ? title : "Unknown title";
    }

    public Integer getYear() {
        return year;
    }

    public String getYearText() {
        return year != null && year > 0 ? String.valueOf(year) : "Unknown year";
    }

    public String getGenre() {
        return genre != null ? genre : "Unknown genre";
    }

    public Integer getPosterResId() {
        return posterResId;
    }
}
