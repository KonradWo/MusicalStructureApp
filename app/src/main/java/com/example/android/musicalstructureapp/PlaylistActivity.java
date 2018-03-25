package com.example.android.musicalstructureapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlaylistActivity extends AppCompatActivity {
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.image_settings)
    ImageView iconSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.song_list);
        ButterKnife.bind(this);

        mToolbar.setTitle(getString(R.string.playlist));
        mToolbar.setNavigationIcon(R.drawable.ic_arrow_back_white_24dp);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        final ArrayList<Song> songs = new ArrayList<Song>();
        songs.add(new Song("Title 1", "Artist 1", R.drawable.cd_cover));
        songs.add(new Song("Title 2", "Artist 2", R.drawable.cd_cover));
        songs.add(new Song("Title 3", "Artist 3", R.drawable.cd_cover));
        songs.add(new Song("Title 4", "Artist 4", R.drawable.cd_cover));
        songs.add(new Song("Title 5", "Artist 5", R.drawable.cd_cover));
        songs.add(new Song("Title 6", "Artist 6", R.drawable.cd_cover));
        songs.add(new Song("Title 7", "Artist 7", R.drawable.cd_cover));
        songs.add(new Song("Title 8", "Artist 8", R.drawable.cd_cover));
        songs.add(new Song("Title 9", "Artist 9", R.drawable.cd_cover));
        songs.add(new Song("Title 10", "Artist 10", R.drawable.cd_cover));

        SongAdapter adapter = new SongAdapter(this, songs);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Song song = songs.get(i);
                Intent playerIntent = new Intent(PlaylistActivity.this, PlayerActivity.class);
                playerIntent.putExtra("songTitle", song.getTitle());
                playerIntent.putExtra("songArtist", song.getArtist());
                startActivity(playerIntent);
            }
        });

        iconSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent iconSettingsIntent = new Intent(PlaylistActivity.this, SettingsActivity.class);
                startActivity(iconSettingsIntent);
            }
        });
    }
}
