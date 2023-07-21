package com.example.eastasiastudiesapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        Thread th = new Thread() {
            public void run() {
                try {
                    Thread.sleep(3000);

                } catch (Exception e) {

                } finally {
                    Intent it = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(it);
                }
            }
        };
        th.start();
    }
}