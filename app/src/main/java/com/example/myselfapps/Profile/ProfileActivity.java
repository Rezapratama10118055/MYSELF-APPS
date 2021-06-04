package com.example.myselfapps.Profile;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.app.Dialog;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.myselfapps.Daily.DailyAcitivtyini;
import com.example.myselfapps.Favorite.MusicFavoriteActivity;
import com.example.myselfapps.Gallery.GalleryActivity;
import com.example.myselfapps.Home.HomeActivity;
import com.example.myselfapps.MainActivity;
import com.example.myselfapps.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ProfileActivity extends AppCompatActivity {

    private Button ShowDialog;
    private Button ShowPeta;
    private Button button;
    private TextView sosial;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile2);
        //03/06/2021, 10118055, Reza Pratama, If-2

        peta();
        call();
        tombol();
        sosialmedia();

        ShowDialog = findViewById(R.id.about);
        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(ProfileActivity.this);

                dialog.setTitle("Tentang Saya");
                dialog.setContentView(R.layout.activity_about);
                Button DialogButton = dialog.findViewById(R.id.ok);
                DialogButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();
                    }
                });

                dialog.show();
            }
        });
    }
    public void peta(){
        ShowPeta = findViewById(R.id.idmap);
        ShowPeta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(ProfileActivity.this, MapsActivity.class));

                }
        });
    }
    public void onButtonTap(View v){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_EMAIL, new String[] {"rezapr21@gmail.com"});

        intent.putExtra(Intent.EXTRA_SUBJECT, "Email dari Aplikasi Android");
        intent.putExtra(Intent.EXTRA_TEXT, "Hai, ini adalah percobaan mengirim email dari aplikasi android");

        try {
            startActivity(Intent.createChooser(intent, "Ingin Mengirim Email ?"));
        } catch (android.content.ActivityNotFoundException ex) {
            //do something else
        }
    }
    public void call(){
    button = (Button) findViewById(R.id.buttonCall);

      button.setOnClickListener(new View.OnClickListener() {
        public void onClick(View arg0) {
            String phoneNumber = "087894803437";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }
    });

}
    public void tombol(){
        BottomNavigationView bottomNavigationView = findViewById(R.id.menu7);
        bottomNavigationView.setSelectedItemId(R.id.myacount);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.myacount:
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
                    case R.id.favorite:
                        startActivity(new Intent(getApplicationContext(), MusicFavoriteActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                }

                return false;
            }
        });
    }
    private void sosialmedia(){
        TextView sosialni = findViewById(R.id.sosial);
        sosialni.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_VIEW);
                intent.addCategory(Intent.CATEGORY_BROWSABLE);
                intent.setData(Uri.parse("https://www.instagram.com/repram21/"));
                startActivity(intent);

            }
        });
    }

}