package com.example.koshik.kidgalleryapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.koshik.kidgalleryapp.R;
import com.example.koshik.kidgalleryapp.adapters.CountryAdapter;


public class CountryFlagFragment extends ListFragment {
    CountryAdapter myAdapter;
    public static CountryFlagFragment getInstance() {
        return new CountryFlagFragment();
    }

    @Override
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


    }
}

