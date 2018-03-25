package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlayerActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.text_player_title)
    TextView mSongTitle;
    @BindView(R.id.text_player_artist)
    TextView mSongArtist;
    @BindView(R.id.image_queue_music)
    ImageView queue;
    @BindView(R.id.image_settings)
    ImageView iconSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.player);
        ButterKnife.bind(this);

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

            mSongTitle.setText(songTitle);
            mSongArtist.setText(songArtist);
        }

        queue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(PlayerActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconSettingsIntent = new Intent(PlayerActivity.this, SettingsActivity.class);
                startActivity(iconSettingsIntent);
            }
        });
    }
}
