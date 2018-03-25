package com.example.android.musicalstructureapp;

public class Song {
    private String mTitle;
    private String mArtist;
    private int mImageResourceId;

    public Song(String title, String artist, int imageResourceId) {
        mTitle = title;
        mArtist = artist;
        mImageResourceId = imageResourceId;
    }

    public String getTitle() {
        return mTitle;
    }

    public String getArtist() {
        return mArtist;
    }

    public int getImageResourceId() {
        return mImageResourceId;
    }
}
