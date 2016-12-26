package com.example.koshik.kidgalleryapp.activities;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.models.AnimalImage;
import com.squareup.picasso.Picasso;

public class AnimalDetailActivity extends AppCompatActivity {
    public static final String EXTRA_ANIMAL = "extra_animal";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.animal_activity_detail);

        Toolbar toolbar = (Toolbar) findViewById( R.id.toolbar );
        setSupportActionBar( toolbar );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );

        AnimalImage animalImage = getIntent().getExtras().getParcelable(EXTRA_ANIMAL);

        TextView species = (TextView) findViewById(R.id.tvSpecies);
        TextView description = (TextView) findViewById(R.id.tvDescription);
        ImageView images = (ImageView) findViewById(R.id.ivImages);

        species.setText(animalImage.getSpecies());
        description.setText(animalImage.getDescription());
        Picasso.with(this).load(animalImage.getImage()).into(images);
    }
}
