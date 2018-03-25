package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.button_playlist)
    Button playlist;
    @BindView(R.id.button_player)
    Button player;
    @BindView(R.id.image_settings)
    ImageView iconSettings;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mToolbar.setTitle(getString(R.string.app_name));

        playlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playlistIntent = new Intent(MainActivity.this, PlaylistActivity.class);
                startActivity(playlistIntent);
            }
        });

        player.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent playerIntent = new Intent(MainActivity.this, PlayerActivity.class);
                startActivity(playerIntent);
            }
        });

        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconSettingsIntent = new Intent(MainActivity.this, SettingsActivity.class);
                startActivity(iconSettingsIntent);
            }
        });
    }
}
