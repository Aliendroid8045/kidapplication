package com.example.koshik.kidgalleryapp.fragments;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.koshik.kidgalleryapp.activities.AnimalDetailActivity;
import com.example.koshik.kidgalleryapp.adapters.AnimalAdapter;
import com.example.koshik.kidgalleryapp.models.AnimalImage;
import com.example.koshik.kidgalleryapp.utils.AnimalApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by koshik on 26-11-2016.
 */

public class AnimalListFragment extends ListFragment {
    private AnimalAdapter animalAdapter;

    public static AnimalListFragment getInstance() {
        return new AnimalListFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        // setListShown(false);
        animalAdapter = new AnimalAdapter(getActivity(), 0);
        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://gist.githubusercontent." +
                        "com/koshik8045/2ff1e5e81118d0720a988067e9016fa9/" +
                        "raw/e295090a82c28f50b5aa1681c13dd268d55b72d7")
                .build();
        AnimalApiInterface animalApiInterface = restAdapter.create(AnimalApiInterface.class);
        animalApiInterface.getStreams(new Callback<List<AnimalImage>>() {
            @Override
            public void success(List<AnimalImage> animalImages, Response response) {
                if (animalImages == null || animalImages.isEmpty())
                    return;
                for (AnimalImage animalImage : animalImages) {
                    animalAdapter.add(animalImage);
                }
                animalAdapter.notifyDataSetChanged();
                setListAdapter(animalAdapter);
                // setListShown(true);
            }

            @Override
            public void failure(RetrofitError error) {
                Log.e("Animal", "Retrofit Error " + error.getMessage());
            }
        });
    }
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        Intent intent = new Intent(getActivity(), AnimalDetailActivity.class);
        intent.putExtra(AnimalDetailActivity.EXTRA_ANIMAL, animalAdapter.getItem(position));
        startActivity(intent);
    }
}
