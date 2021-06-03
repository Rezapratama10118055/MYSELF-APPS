package com.example.myselfapps.Favorite;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.media.MediaMetadata;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.myselfapps.Daily.DailyAcitivtyini;
import com.example.myselfapps.Gallery.GalleryActivity;
import com.example.myselfapps.Home.HomeActivity;
import com.example.myselfapps.Profile.ProfileActivity;
import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.IOException;



public class MusicFavoriteActivity extends AppCompatActivity  implements View.OnClickListener {

    private Button Play, Pause, Stop;
    private MediaPlayer mediaPlayer;

    //03/06/2021, 10118055, Reza Pratama, If-2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_favorite);

        tombol();
        tombolvidio();


        mediaPlayer = MediaPlayer.create(MusicFavoriteActivity.this, R.raw.laguku);

        Play = findViewById(R.id.play);
        Pause = findViewById(R.id.pause);
        Stop = findViewById(R.id.stop);


        Play.setOnClickListener(this);
        Pause.setOnClickListener(this);
        Stop.setOnClickListener(this);
        stateAwal();
    }

    private void stateAwal() {
        Play.setEnabled(true);
        Pause.setEnabled(false);
        Stop.setEnabled(false);
    }


    private void playAudio() {
        mediaPlayer = MediaPlayer.create(this, R.raw.laguku);


        Play.setEnabled(false);
        Pause.setEnabled(true);
        Stop.setEnabled(true);


        try{
            mediaPlayer.prepare();
        }catch (IllegalStateException ex){
            ex.printStackTrace();
        }catch (IOException ex1){
            ex1.printStackTrace();
        }
        mediaPlayer.start();


        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                stateAwal();
            }
        });
    }




    @SuppressLint("SetTextI18n")
    private void pauseAudio() {

        if(mediaPlayer.isPlaying()){
            if(mediaPlayer != null){
                mediaPlayer.pause();
                Pause.setText("Lanjutkan");
            }
        }else {


            if(mediaPlayer != null){
                mediaPlayer.start();
                Pause.setText("Pause");
            }
        }

    }


    private void stopAudio() {
        mediaPlayer.stop();
        try {

            mediaPlayer.prepare();
            mediaPlayer.seekTo(0);
        }catch (Throwable t){
            t.printStackTrace();
        }
        stateAwal();
    }



    @Override
    public void onClick(View v) {
        switch (v.getId()) {
                case R.id.play:
                    playAudio();
                    break;

                case R.id.pause:
                    pauseAudio();
                    break;

                case R.id.stop:
                    stopAudio();
                    break;
            }
        }

        public void tombol(){
            BottomNavigationView bottomNavigationView = findViewById(R.id.menu2);
            bottomNavigationView.setSelectedItemId(R.id.favorite);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.favorite:
                            return true;
                        case R.id.dilay:
                            startActivity(new Intent(getApplicationContext(), DailyAcitivtyini.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.home:
                            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.galery:
                            startActivity(new Intent(getApplicationContext(), GalleryActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                        case R.id.myacount:
                            startActivity(new Intent(getApplicationContext(), ProfileActivity.class));
                            overridePendingTransition(0, 0);
                            return true;
                    }

                    return false;
                }
            });
        }
        public void tombolvidio(){
            BottomNavigationView bottomNavigationView = findViewById(R.id.menu3);
            bottomNavigationView.setSelectedItemId(R.id.music);
            bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    switch (item.getItemId()) {
                        case R.id.music:
                            return true;
                        case R.id.library:
                            startActivity(new Intent(getApplicationContext(), VideoActivity.class));
                            overridePendingTransition(0, 0);
                            return true;

                    }

                    return false;
                }
            });
        }


    }
