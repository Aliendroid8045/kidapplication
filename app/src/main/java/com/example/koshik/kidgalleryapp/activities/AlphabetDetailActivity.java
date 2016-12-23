package com.example.koshik.kidgalleryapp.activities;

import android.os.StrictMode;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.koshik.kidgalleryapp.R;
import com.squareup.picasso.Picasso;

public class AlphabetDetailActivity extends FragmentActivity {
    public static final String EXTRA_IMAGE = "extra_image";
    private ImageView myImage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.alphabet_activity_detail);
        myImage = (ImageView) findViewById(R.id.largeImage);


        if (getIntent() != null && getIntent().getExtras() != null) {
            if (getIntent().getExtras().containsKey(EXTRA_IMAGE)) {
                Picasso.with(this).load(getIntent().getExtras().getString(EXTRA_IMAGE)).into(myImage);
            }
        }
    }
}
