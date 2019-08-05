package com.nghiatv.exercise;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class SongDetailFragment extends Fragment {
    private ImageView imageCover;
    private TextView textSongTitle;
    private TextView textSongArtist;
    private TextView textSongYear;
    private TextView textAlbumTrackNumber;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_song_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        imageCover = view.findViewById(R.id.imageCover);
        textSongTitle = view.findViewById(R.id.textSongTitle);
        textSongArtist = view.findViewById(R.id.textSongArtist);
        textSongYear = view.findViewById(R.id.textSongYear);
        textAlbumTrackNumber = view.findViewById(R.id.textAlbumTrackNumber);

        Intent intent = getActivity().getIntent();
        Song song = (Song) intent.getSerializableExtra(SongListFragment.KEY);
        Bitmap bitmap = ImageUtils.loadImage(song.getData());
        if (bitmap != null)
            imageCover.setImageBitmap(bitmap);
        textSongTitle.setText(song.getTitle());
        textSongArtist.setText(song.getArtistName());
        textSongYear.setText(String.valueOf(song.getYear()));
        textAlbumTrackNumber.setText(String.valueOf(song.getTrack()));
    }
}
