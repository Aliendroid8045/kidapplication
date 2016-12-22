package com.example.koshik.kidgalleryapp.activities;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.koshik.kidgalleryapp.R;

public class SplashActivity extends AppCompatActivity {
    private ImageView mySplashImage;
    private Handler splashHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        mySplashImage = (ImageView) findViewById(R.id.ivSplashScreen);
        splashHandler = new Handler();

        MyThread myThread = new MyThread();
        Thread t = new Thread(myThread);
        t.start();
    }

    private class MyThread implements Runnable {

        @Override
        public void run() {
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    startActivity(intent);
                    SplashActivity.this.finish();
                }
            };
            splashHandler.postDelayed(runnable, 2000);
        }
    }
}
