package com.example.myselfapps.Gallery;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myselfapps.Daily.DailyAcitivtyini;
import com.example.myselfapps.Favorite.MusicFavoriteActivity;
import com.example.myselfapps.Home.HomeActivity;
import com.example.myselfapps.Profile.ProfileActivity;
import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class GalleryActivity extends AppCompatActivity {

    protected GridView gridView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);
        tombol();
        //03/06/2021, 10118055, Reza Pratama, If-2

        gridView = findViewById(R.id.grid_view);
        gridView.setAdapter(new ImageAdapter(this));

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView parent, View v, int position, long id) {
                Toast.makeText(GalleryActivity.this, "" + position, Toast.LENGTH_SHORT).show();
            }
        });


    }
    public void tombol(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu6);
        bottomNavigationView.setSelectedItemId(R.id.galery);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.galery:
                        return true;
                    case R.id.dilay:
                        startActivity(new Intent(getApplicationContext(), DailyAcitivtyini.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(), MusicFavoriteActivity.class));
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
     class ImageAdapter extends BaseAdapter {
         private int[] gambar = {
                 R.drawable.galeri1, R.drawable.galeri2, R.drawable.galeri3,R.drawable.galeri4, R.drawable.galeri5, R.drawable.galeri6,
         };

         private Context mContext;
         ImageAdapter(Context c) {
             mContext = c;
         }
         public int getCount() {

             return gambar.length;
         }

         public Object getItem(int position) {
             return null;
         }

         public long getItemId(int position) {
             return 0;
         }
         public View getView(int position, View convertView, ViewGroup parent) {
             ImageView imageView;
             TextView textView;

             if (convertView == null) {

                 imageView = new ImageView(mContext);

                 imageView.setLayoutParams(new GridView.LayoutParams(300, 300));
                 imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

                 imageView.setPadding(3, 10, 3, 10);
             } else {
                 imageView = (ImageView) convertView;
             }


             imageView.setImageResource(gambar[position]);
             return imageView;
         }


     }
