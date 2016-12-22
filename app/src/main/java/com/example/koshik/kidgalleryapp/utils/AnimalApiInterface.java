package com.example.koshik.kidgalleryapp.utils;

import com.example.koshik.kidgalleryapp.models.AnimalImage;

import java.util.List;

import retrofit.http.GET;
import retrofit.Callback;


/**
 * Created by koshik on 27-11-2016.
 */
public interface AnimalApiInterface {

    @GET("/AnimalGallery.Json")
    void getStreams(Callback<List<AnimalImage>> callback);
}

