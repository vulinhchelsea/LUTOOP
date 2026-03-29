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
import com.example.soccermanager.data.models.Player;

public class PlayerAdapter extends ListAdapter<Player, PlayerAdapter.PlayerViewHolder> {

    public interface OnPlayerClickListener {
        void onPlayerClick(Player player);
    }

    private final OnPlayerClickListener listener;

    public PlayerAdapter(OnPlayerClickListener listener) {
        super(DIFF_CALLBACK);
        this.listener = listener;
    }

    private static final DiffUtil.ItemCallback<Player> DIFF_CALLBACK =
            new DiffUtil.ItemCallback<Player>() {
                @Override
                public boolean areItemsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
                    return oldItem.getId() == newItem.getId();
                }

                @Override
                public boolean areContentsTheSame(@NonNull Player oldItem, @NonNull Player newItem) {
                    return oldItem.getName().equals(newItem.getName());
                }
            };

    @NonNull
    @Override
    public PlayerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_player, parent, false);
        return new PlayerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlayerViewHolder holder, int position) {
        Player player = getItem(position);
        holder.bind(player, listener);
    }

    static class PlayerViewHolder extends RecyclerView.ViewHolder {

        TextView nameView, ageView, teamView;

        public PlayerViewHolder(@NonNull View itemView) {
            super(itemView);
            nameView = itemView.findViewById(R.id.playerName);
            ageView = itemView.findViewById(R.id.playerAge);
            teamView = itemView.findViewById(R.id.playerTeam);
        }

        void bind(Player player, OnPlayerClickListener listener) {
            nameView.setText(player.getName());
            ageView.setText("Age: " + player.getAge());
            teamView.setText("Team: " + player.getTeamName());
            itemView.setOnClickListener(v -> listener.onPlayerClick(player));
        }
    }
}