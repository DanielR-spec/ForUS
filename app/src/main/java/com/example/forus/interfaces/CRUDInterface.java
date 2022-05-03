package com.example.forus.interfaces;

import com.example.forus.model.Image;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CRUDInterface {
    @GET("imagen")
    Call<List<Image>> getAll();
}
