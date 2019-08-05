package com.nghiatv.exercise;

import android.content.Context;
import android.database.Cursor;
import android.provider.MediaStore;

import java.util.ArrayList;
import java.util.List;

public class SongLoader {
    private static String[] projection = new String[]{
            MediaStore.Audio.AudioColumns.TITLE,
            MediaStore.Audio.AudioColumns.TRACK,
            MediaStore.Audio.AudioColumns.YEAR,
            MediaStore.Audio.AudioColumns.DURATION,
            MediaStore.Audio.AudioColumns.SIZE,
            MediaStore.Audio.AudioColumns.DATA,
            MediaStore.Audio.AudioColumns.ALBUM,
            MediaStore.Audio.AudioColumns.ARTIST_ID,
            MediaStore.Audio.AudioColumns.ARTIST
    };

    public static List<Song> getAllSongs(Context context) {
        Cursor cursor = makeSongCursor(context);
        return getSongs(cursor);
    }

    private static List<Song> getSongs(Cursor cursor) {
        List<Song> songs = new ArrayList<>();

        if (cursor != null && cursor.moveToFirst()) {
            do {
                Song song = new Song(cursor);
                if (song.getDuration() >= 30000) {
                    songs.add(song);
                }
            } while (cursor.moveToNext());

            cursor.close();

        }

        return songs;
    }

    private static Cursor makeSongCursor(Context context) {
        try {
            return context.getContentResolver().query(
                    MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                    projection,
                    null,
                    null,
                    null
            );

        } catch (SecurityException e) {
            return null;
        }
    }
}
