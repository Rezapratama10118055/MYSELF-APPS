package com.example.myselfapps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.myselfapps.Viewpages.ViewPagerslide;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        //03/06/2021, 10118055, Reza Pratama, If-2

        Thread thread = new Thread(){
            public void run(){
                try{
                    sleep(5000);
                }catch(InterruptedException ex){
                    ex.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreen.this, ViewPagerslide.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}
