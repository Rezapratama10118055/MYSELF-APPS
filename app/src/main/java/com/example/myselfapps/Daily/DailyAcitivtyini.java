package com.example.myselfapps.Daily;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.LinearLayout;

import com.example.myselfapps.Favorite.MusicFavoriteActivity;
import com.example.myselfapps.Gallery.GalleryActivity;
import com.example.myselfapps.Home.HomeActivity;
import com.example.myselfapps.Profile.ProfileActivity;
import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.Arrays;

public class DailyAcitivtyini extends AppCompatActivity {

    RecyclerView recyclerView;
    RecyclerView.Adapter AdapterVertikal;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<itemModel>data;

    RecyclerView recyclerViewdua;
    RecyclerView.Adapter AdapterHorizontal;
    RecyclerView.LayoutManager layoutManagerHorizontal;
    ArrayList<itemModelTeman>dataku;



    //03/06/2021, 10118055, Reza Pratama, If-2


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_acitivty);

        recyclerView = findViewById(R.id.recyleview);
        recyclerView.setHasFixedSize(true);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
        data = new ArrayList<>();
        for(int i = 0; i < myItem.personNames.length; i++ ){
            data.add(new itemModel(myItem.personNames[i],myItem.waktu[i], myItem.personImages[i]));
        }
        AdapterVertikal = new AdapterRecyclerView(data);
        recyclerView.setAdapter(AdapterVertikal);
        Horizonral();
        tombol();







    }
    public void Horizonral(){
        //Horizontal
        recyclerViewdua = findViewById(R.id.recyleviewdua);
        recyclerViewdua.setHasFixedSize(true);
       LinearLayoutManager layoutManagerHorizontal = new LinearLayoutManager(this);
        layoutManagerHorizontal.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerViewdua.setLayoutManager(layoutManagerHorizontal);
        recyclerViewdua.addItemDecoration(new DividerItemDecoration(this, LinearLayout.HORIZONTAL));
        dataku = new ArrayList<>();
        for(int i = 0; i < myItem.namateman.length; i++ ){
            dataku.add(new itemModelTeman(myItem.namateman[i],myItem.status[i], myItem.imageteman[i]));
        }
        AdapterHorizontal = new AdapterRecyclerViewHerizontal(dataku);
        recyclerViewdua.setAdapter(AdapterHorizontal);
    }
    public void tombol(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu5);
        bottomNavigationView.setSelectedItemId(R.id.dilay);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.dilay:
                        return true;
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(), MusicFavoriteActivity.class));
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



}
