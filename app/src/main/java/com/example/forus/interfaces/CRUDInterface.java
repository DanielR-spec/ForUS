package com.example.forus.interfaces;

import com.example.forus.dto.ImageDto;
import com.example.forus.model.Imagen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Body;


public interface CRUDInterface {
    @GET("imagen")
    Call<List<Imagen>> getAll();

    @GET("imagen/{id}")
    Call<Imagen> getOne(@Path("id") int id);

    @POST("imagen")
    Call<Imagen> create(@Body ImageDto dto);
}
