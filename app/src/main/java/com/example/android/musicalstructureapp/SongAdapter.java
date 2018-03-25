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

import butterknife.BindView;
import butterknife.ButterKnife;

public class SongAdapter extends ArrayAdapter<Song> {
    public SongAdapter(Context context, ArrayList<Song> songs) {
        super(context, 0, songs);
    }

    static class ViewHolder {
        @BindView(R.id.text_list_title)
        TextView titleTextView;
        @BindView(R.id.text_list_artist)
        TextView artistTextView;
        @BindView(R.id.image_cover)
        ImageView coverImageView;

        public ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        Song currentSong = getItem(position);

        if (currentSong != null) {
            holder.titleTextView.setText(currentSong.getTitle());
            holder.artistTextView.setText(currentSong.getArtist());
            holder.coverImageView.setImageResource(currentSong.getImageResourceId());
        }

        return convertView;
    }
}
