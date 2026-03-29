package com.example.soccermanager.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.soccermanager.R;
import com.example.soccermanager.data.models.Match;

public class MatchAdapter extends ListAdapter<Match, MatchAdapter.MatchViewHolder> {

    public interface OnMatchClickListener {
        void onMatchClick(Match match);
    }

    private final OnMatchClickListener listener;

    public MatchAdapter(OnMatchClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<Match> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Match>() {
                @Override
                public boolean areItemsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Match oldItem, @NonNull Match newItem) {
                    return oldItem.getHomeTeam().equals(newItem.getHomeTeam()) &&
                            oldItem.getAwayTeam().equals(newItem.getAwayTeam());
                }
            };

    @NonNull
    @Override
    public MatchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_match, parent, false);
        return new MatchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MatchViewHolder holder, int position) {
        Match match = getItem(position);
        holder.bind(match, listener);
    }

    static class MatchViewHolder extends RecyclerView.ViewHolder {

        TextView teamsView, dateView;

        public MatchViewHolder(@NonNull View itemView) {
            super(itemView);
            teamsView = itemView.findViewById(R.id.matchTeams);
            dateView = itemView.findViewById(R.id.matchDate);
        }

        void bind(Match match, OnMatchClickListener listener) {
            teamsView.setText(match.getHomeTeam() + " vs " + match.getAwayTeam());
            dateView.setText("Date: " + match.getDate());
            itemView.setOnClickListener(v -> listener.onMatchClick(match));
        }
    }
}