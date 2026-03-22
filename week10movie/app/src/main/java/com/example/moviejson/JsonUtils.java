package com.example.moviejson;

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.example.moviejson.Movie;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class JsonUtils {

    private static final String TAG = "JsonUtils";

    public static List<Movie> loadMoviesFromJson(Context context) throws Exception {
        List<Movie> movies = new ArrayList<>();
        String jsonString = loadJsonFromAssets(context, "movies.json");

        if (jsonString == null) {
            throw new IOException("movies.json file not found or could not be read");
        }

        try {
            JSONArray jsonArray = new JSONArray(jsonString);

            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.optJSONObject(i);
                if (obj == null) {
                    Log.w(TAG, "Skipping non-object entry at index " + i);
                    continue;
                }

                Movie movie = parseMovieObject(context, obj, i);
                if (movie != null) {
                    movies.add(movie);
                }
            }

        } catch (JSONException e) {
            // Invalid JSON format
            Log.e(TAG, "JSON parsing error", e);
            throw new JSONException("Invalid JSON format in movies.json");
        }

        return movies;
    }

    private static String loadJsonFromAssets(Context context, String fileName) {
        try {
            InputStream is = context.getAssets().open(fileName);
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(is, StandardCharsets.UTF_8)
            );
            StringBuilder sb = new StringBuilder();
            String line;

            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            reader.close();
            return sb.toString();

        } catch (IOException e) {
            Log.e(TAG, "Error reading JSON file: " + fileName, e);
            return null;
        }
    }

    private static Movie parseMovieObject(Context context, JSONObject obj, int index) {
        // Required fields: title, year, genre, poster (by assignment)
        String rawTitle = obj.optString("title", null);
        Object yearObj = obj.opt("year");
        String rawGenre = obj.optString("genre", null);
        String posterKey = obj.optString("poster", null);

        // Missing required fields
        if (rawTitle == null || rawTitle.trim().isEmpty()) {
            Log.w(TAG, "Missing or null title at index " + index + ", skipping movie");
            return null;
        }

        // Parse year safely
        Integer year = null;
        if (yearObj != null && !JSONObject.NULL.equals(yearObj)) {
            try {
                if (yearObj instanceof Number) {
                    int y = ((Number) yearObj).intValue();
                    if (y > 0) {
                        year = y;
                    } else {
                        Log.w(TAG, "Invalid year (negative or zero) for " + rawTitle);
                    }
                } else if (yearObj instanceof String) {
                    int y = Integer.parseInt((String) yearObj);
                    if (y > 0) {
                        year = y;
                    } else {
                        Log.w(TAG, "Invalid year (negative or zero) for " + rawTitle);
                    }
                } else {
                    Log.w(TAG, "Unsupported year type for " + rawTitle);
                }
            } catch (NumberFormatException e) {
                Log.w(TAG, "Year not a valid number for " + rawTitle + ": " + yearObj);
            }
        }

        // Genre can be null → we’ll show placeholder text
        String genre = rawGenre;

        // Map poster string to drawable resource id
        Integer posterResId = null;
        if (posterKey != null && !posterKey.trim().isEmpty()) {
            posterResId = getPosterResId(context, posterKey);
        }

        return new Movie(rawTitle, year, genre, posterResId);
    }

    private static Integer getPosterResId(Context context, String posterKey) {
        // posterKey like "matrix_poster" → drawable/matrix_poster
        Resources res = context.getResources();
        int resId = res.getIdentifier(posterKey, "drawable", context.getPackageName());
        if (resId == 0) {
            Log.w(TAG, "Poster resource not found for key: " + posterKey);
            return null;
        }
        return resId;
    }
}