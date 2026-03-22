package com.example.moviejson;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.moviejson.Movie;
import com.example.moviejson.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView movieRecyclerView;
    private MovieAdapter adapter;
    private TextView errorTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        movieRecyclerView = findViewById(R.id.movieRecyclerView);
        errorTextView = findViewById(R.id.errorTextView);

        setupRecyclerView();
        loadMovieData();
    }

    private void setupRecyclerView() {
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MovieAdapter(this, new ArrayList<Movie>());
        movieRecyclerView.setAdapter(adapter);
    }

    private void loadMovieData() {
        try {
            List<Movie> movies = JsonUtils.loadMoviesFromJson(this);
            Toast.makeText(this, "Movies loaded: " + movies.size(), Toast.LENGTH_SHORT).show();
            if (movies.isEmpty()) {
                showError("No valid movies found in JSON file.");
            } else {
                hideError();
                adapter.updateMovies(movies);
            }
        } catch (Exception e) {
            // Handle all high-level errors here
            showError("Failed to load movies: " + e.getMessage());
        }
    }

    private void showError(String message) {
        errorTextView.setText(message);
        errorTextView.setVisibility(View.VISIBLE);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }

    private void hideError() {
        errorTextView.setVisibility(View.GONE);
    }
}