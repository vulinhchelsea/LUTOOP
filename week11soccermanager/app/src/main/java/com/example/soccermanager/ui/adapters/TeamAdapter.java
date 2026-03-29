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
import com.example.soccermanager.data.models.Team;

public class TeamAdapter extends ListAdapter<Team, TeamAdapter.TeamViewHolder> {

    public interface OnTeamClickListener {
        void onTeamClick(Team team);
    }

    private final OnTeamClickListener listener;

    public TeamAdapter(OnTeamClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<Team> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Team>() {
                @Override
                public boolean areItemsTheSame(@NonNull Team oldItem, @NonNull Team newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Team oldItem, @NonNull Team newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }
            };

    @NonNull
    @Override
    public TeamViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_team, parent, false);
        return new TeamViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TeamViewHolder holder, int position) {
        Team team = getItem(position);
        holder.bind(team, listener);
    }

    static class TeamViewHolder extends RecyclerView.ViewHolder {

        TextView nameView;
        TextView countryView;

        public TeamViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.teamName);
            countryView = itemView.findViewById(R.id.teamCountry);
        }

        void bind(Team team, OnTeamClickListener listener) {
            nameView.setText(team.getName());
            countryView.setText(team.getCountry());

            itemView.setOnClickListener(v -> listener.onTeamClick(team));
        }
    }
}