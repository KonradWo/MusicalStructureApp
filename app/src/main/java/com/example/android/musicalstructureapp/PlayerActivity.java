package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class PlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);

        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mToolbar.setTitle(getString(R.string.player));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String songTitle = extras.getString("songTitle");
            String songArtist = extras.getString("songArtist");

            TextView mSongTitle = (TextView) findViewById(R.id.text_player_title);
            mSongTitle.setText(songTitle);

            TextView mSongArtist = (TextView) findViewById(R.id.text_player_artist);
            mSongArtist.setText(songArtist);
        }

        ImageView queue = (ImageView) findViewById(R.id.image_queue_music);
        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(PlayerActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        ImageView iconSettings = (ImageView) findViewById(R.id.image_settings);
        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconSettingsIntent = new Intent(PlayerActivity.this, SettingsActivity.class);
                startActivity(iconSettingsIntent);
            }
        });
    }
}
