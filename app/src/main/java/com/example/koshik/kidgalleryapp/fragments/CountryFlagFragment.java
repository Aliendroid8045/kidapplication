package com.example.koshik.kidgalleryapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.activities.CountryFlagDetailActivity;
import com.example.koshik.kidgalleryapp.adapters.CountryAdapter;
import com.example.koshik.kidgalleryapp.models.CountryIModelPojo;
import com.example.koshik.kidgalleryapp.utils.CountryFlagApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class CountryFlagFragment extends ListFragment {
    CountryAdapter countryAdapter;

    public static CountryFlagFragment getInstance() {
        return new CountryFlagFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // setListShown(false);
        countryAdapter = new CountryAdapter(getActivity(), 0);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://gist.githubusercontent.com/" +
                        "koshik8045/9ce01565b3d1ef699ae7716e229e62ba/" +
                        "raw/4c921777c17599b2ce10c23fc84858f7d65f388d").build();
        CountryFlagApiInterface flagApiInterface = restAdapter.create(CountryFlagApiInterface.class);
        flagApiInterface.getStreams(new Callback<List<CountryIModelPojo>>() {
            @Override
            public void success(List<CountryIModelPojo> countryIModelPojos, Response response) {
                if (countryIModelPojos == null || countryIModelPojos.isEmpty())
                    return;
                for (CountryIModelPojo modelPojo : countryIModelPojos) {
                    countryAdapter.add(modelPojo);
                }
                countryAdapter.notifyDataSetChanged();
                setListAdapter(countryAdapter);
                //setListShown(true);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Country", "Retrofit Error" + error.getMessage());
            }
        });
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), CountryFlagDetailActivity.class);
        intent.putExtra(CountryFlagDetailActivity.EXTRA_COUNTRY_FLAG, countryAdapter.getItem(position));
        startActivity(intent);
    }
    /* @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return super.onCreateView(inflater, container, savedInstanceState);
    }
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        myAdapter = new CountryAdapter(getActivity());
        setListAdapter(myAdapter);
    }*/
}

