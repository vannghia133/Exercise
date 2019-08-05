package com.nghiatv.exercise;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private OnItemClickedListener listener;
    private List<Song> songs = new ArrayList<>();

    public SongAdapter(OnItemClickedListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_song, viewGroup, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.bindData(songs.get(i));
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onSongClicked(songs.get(i));
            }
        });
    }

    public void addSongs(List<Song> songs) {
        this.songs.clear();
        this.songs = songs;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return songs.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView textSongTitle;
        private TextView textSongSize;
        private TextView textSongDuration;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textSongTitle = itemView.findViewById(R.id.textSongTitle);
            textSongSize = itemView.findViewById(R.id.textSongSize);
            textSongDuration = itemView.findViewById(R.id.textSongDuration);
        }

        public void bindData(Song song) {
            textSongTitle.setText(song.getTitle());
            textSongSize.setText(String.valueOf(song.getSize()));
            textSongDuration.setText(String.valueOf(song.getDuration()));
        }
    }

    interface OnItemClickedListener {
        void onSongClicked(Song song);
    }
}
