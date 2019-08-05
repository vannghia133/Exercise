package com.nghiatv.exercise;

import android.database.Cursor;
import android.provider.MediaStore;

import java.io.Serializable;

public class Song implements Serializable {
    private String title;
    private int track;
    private int year;
    private int duration;
    private int size;
    private String data;
    private String albumName;
    private int artistId;
    private String artistName;

    public Song() {
        this.title = "";
        this.track = -1;
        this.year = -1;
        this.duration = -1;
        this.size = -1;
        this.data = "";
        this.albumName = "";
        this.artistId = -1;
        this.artistName = "";
    }

    public Song(Cursor cursor) {
        this.title = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TITLE));
        this.track = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.TRACK));
        this.year = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.YEAR));
        this.duration = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DURATION));
        this.size = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.SIZE));
        this.data = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.DATA));
        this.albumName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ALBUM));
        this.artistId = cursor.getInt(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST_ID));
        this.artistName = cursor.getString(cursor.getColumnIndex(MediaStore.Audio.AudioColumns.ARTIST));
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getTrack() {
        return track;
    }

    public void setTrack(int track) {
        this.track = track;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getAlbumName() {
        return albumName;
    }

    public void setAlbumName(String albumName) {
        this.albumName = albumName;
    }

    public int getArtistId() {
        return artistId;
    }

    public void setArtistId(int artistId) {
        this.artistId = artistId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }
}
