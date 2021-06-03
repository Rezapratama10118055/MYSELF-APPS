package com.example.myselfapps.Favorite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class VideoActivity extends AppCompatActivity {


    private VideoView videoView;
    private MediaController mediaController;
    private Button playVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        tombolvidio();


        videoView = findViewById(R.id.video);
            playVideo = findViewById(R.id.play);
            mediaController = new MediaController(this);



            playVideo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {


                    Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.video);

                    videoView.setVideoURI(uri);


                    videoView.setMediaController(mediaController);
                    mediaController.setAnchorView(videoView);


                    videoView.start();
                }
            });
        }
    public void tombolvidio(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu4);
        bottomNavigationView.setSelectedItemId(R.id.library);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.library:
                        return true;
                    case R.id.music:
                        startActivity(new Intent(getApplicationContext(), MusicFavoriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;

                }

                return false;
            }
        });
    }
}

