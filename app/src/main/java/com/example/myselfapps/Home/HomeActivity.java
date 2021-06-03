package com.example.myselfapps.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Switch;

import com.example.myselfapps.Daily.DailyAcitivtyini;
import com.example.myselfapps.Favorite.MusicFavoriteActivity;
import com.example.myselfapps.Gallery.GalleryActivity;
import com.example.myselfapps.MainActivity;
import com.example.myselfapps.Profile.ProfileActivity;
import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        //03/06/2021, 10118055, Reza Pratama, If-2


        BottomNavigationView bottomNavigationView = findViewById(R.id.menu);
        bottomNavigationView.setSelectedItemId(R.id.home);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home:
                        return true;
                    case R.id.dilay:
                        startActivity(new Intent(getApplicationContext(), DailyAcitivtyini.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(), MusicFavoriteActivity.class));
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
}