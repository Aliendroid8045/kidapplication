package com.example.koshik.kidgalleryapp.fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.activities.AlphabetDetailActivity;
import com.example.koshik.kidgalleryapp.adapters.AlphabetAdapter;
import com.example.koshik.kidgalleryapp.models.AlphabetImage;
import com.example.koshik.kidgalleryapp.utils.AlphabetApiInterface;

import java.util.List;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by koshik on 26-11-2016.
 */

public class AlphabetFragment extends Fragment implements AdapterView.OnItemClickListener {

    private GridView gridView;
    private AlphabetAdapter alphabetAdapter;

    public static AlphabetFragment getInstance() {
        return new AlphabetFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.alphabet_thumbnail_grid, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        gridView = (GridView) view.findViewById(R.id.gridView);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        alphabetAdapter = new AlphabetAdapter(getActivity());
        gridView.setAdapter(alphabetAdapter);
        gridView.setOnItemClickListener(this);
        gridView.setDrawSelectorOnTop(true);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint("https://gist.githubusercontent.com/koshik8045/a04c67f101526d9faf2e1f3f83c4136a/raw/b68c1182d354fdb44269d78116c0b4920aae2bf5").build();
        AlphabetApiInterface alphabetApiInterface = restAdapter.create(AlphabetApiInterface.class);

        alphabetApiInterface.getStreams(new Callback<List<AlphabetImage>>() {
            @Override
            public void success(List<AlphabetImage> alphabetImages, Response response) {
                if (alphabetImages == null || alphabetImages.isEmpty())
                    return;
                for (AlphabetImage images : alphabetImages) {
                    alphabetAdapter.add(images);
                }
                alphabetAdapter.notifyDataSetChanged();
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        AlphabetImage alphabetImage = (AlphabetImage) parent.getItemAtPosition(position);
        Intent intent = new Intent(getActivity(), AlphabetDetailActivity.class);
        intent.putExtra(AlphabetDetailActivity.EXTRA_IMAGE, alphabetImage.getImage());
        startActivity(intent);
    }
}
