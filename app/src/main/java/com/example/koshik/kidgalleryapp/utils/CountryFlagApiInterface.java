package com.example.koshik.kidgalleryapp.utils;

import com.example.koshik.kidgalleryapp.models.AnimalImage;
import com.example.koshik.kidgalleryapp.models.CountryIModelPojo;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by koshik on 23-12-2016.
 */

public interface CountryFlagApiInterface {

    @GET("/CountryFlags.Json")
    void getStreams(Callback<List<CountryIModelPojo>> callback);
}
