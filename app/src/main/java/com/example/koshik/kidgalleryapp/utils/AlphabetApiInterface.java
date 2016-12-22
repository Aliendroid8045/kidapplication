package com.example.koshik.kidgalleryapp.utils;

import com.example.koshik.kidgalleryapp.models.AlphabetImage;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by koshik on 02-12-2016.
 */

public interface AlphabetApiInterface {
    @GET("/Alphabet.Json")
    void getStreams(Callback<List<AlphabetImage>> callback);
}
