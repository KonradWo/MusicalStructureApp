package com.example.android.musicalstructureapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Song currentSong = getItem(position);

        TextView titleTextView = (TextView) listItemView.findViewById(R.id.text_list_title);
        titleTextView.setText(currentSong.getTitle());

        TextView artistTextView = (TextView) listItemView.findViewById(R.id.text_list_artist);
        artistTextView.setText(currentSong.getArtist());

        ImageView coverImageView = (ImageView) listItemView.findViewById(R.id.image_cover);
        coverImageView.setImageResource(currentSong.getmImageResourceId());

        return listItemView;
    }
}
