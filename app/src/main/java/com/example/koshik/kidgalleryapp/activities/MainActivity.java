package com.example.koshik.kidgalleryapp.activities;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.support.v7.widget.SearchView;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.app.SearchManager;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.adapters.CountryAdapter;
import com.example.koshik.kidgalleryapp.events.DrawerSectionItemClickedEvent;
import com.example.koshik.kidgalleryapp.fragments.Aboutus;
import com.example.koshik.kidgalleryapp.fragments.AnimalListFragment;
import com.example.koshik.kidgalleryapp.fragments.AlphabetFragment;
import com.example.koshik.kidgalleryapp.fragments.ColorFragment;
import com.example.koshik.kidgalleryapp.fragments.CountryFlagFragment;
import com.example.koshik.kidgalleryapp.fragments.PrivacyFragment;
import com.example.koshik.kidgalleryapp.fragments.VegetableFragment;
import com.example.koshik.kidgalleryapp.utils.EventBus;
import com.squareup.otto.Subscribe;

import java.util.zip.Inflater;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout myDrawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private String mCurrentFragmentTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        handleIntent(getIntent());

        myDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerToggle = new ActionBarDrawerToggle(this, myDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(R.string.drawer_open);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
                if (getSupportActionBar() != null)
                    getSupportActionBar().setTitle(R.string.drawer_close);
            }
        };
        //noinspection deprecation,deprecation,deprecation
        myDrawerLayout.setDrawerListener(drawerToggle);
        displayInitialFragment();
    }

    @Override
    protected void onNewIntent(Intent intent) {
        handleIntent(intent);
    }

    private void handleIntent(Intent intent) {

        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
        }
    }

    private void displayInitialFragment() {
        getSupportFragmentManager().beginTransaction().replace(R.id.container, AnimalListFragment.getInstance()).commit();
        mCurrentFragmentTitle = "Animal";
    }

    @Override
    public void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return drawerToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_country_flag_detail, menu);

       /* SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));
        searchView.setSubmitButtonEnabled(true);
        searchView.setOnQueryTextListener((SearchView.OnQueryTextListener) getApplicationContext());*/
        return true;
    }

   /* @Override
    public boolean onQueryTextSubmit(String query) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String newText) {
        return false;
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getInstance().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getInstance().unregister(this);
    }

    @Subscribe
    public void onDrawerSectionItemClickEvent(DrawerSectionItemClickedEvent event) {
        myDrawerLayout.closeDrawers();
        if (event == null || TextUtils.isEmpty(event.section) || event.section.equalsIgnoreCase(mCurrentFragmentTitle)) {
            return;
        }
        if (event.section.equalsIgnoreCase("Animal")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, AnimalListFragment.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Alphabet")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, AlphabetFragment.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Vegetable")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, Aboutus.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Color")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, ColorFragment.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("About Us")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, Aboutus.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Vegetables")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, VegetableFragment.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Countries")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, CountryFlagFragment.getInstance()).commit();
        } else if (event.section.equalsIgnoreCase("Privacy")) {
            getSupportFragmentManager().beginTransaction().replace(R.id.container, PrivacyFragment.getInstance()).commit();
        } else {
            return;
        }
        mCurrentFragmentTitle = event.section;
    }


}