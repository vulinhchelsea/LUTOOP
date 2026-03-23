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
        if (title == null || title.trim().isEmpty() || title.equalsIgnoreCase("null")) {
            return "Unknown title";
        }
        return title;
    }

    public Integer getYear() {
        return year;
    }

    public String getYearText() {
        return year != null && year > 0 ? String.valueOf(year) : "Unknown year";
    }


    public String getGenre() {
        if (genre == null || genre.trim().isEmpty() || genre.equalsIgnoreCase("null")) {
            return "Unknown genre";
        }
        return genre;
    }

    public Integer getPosterResId() {
        return posterResId;
    }
}
