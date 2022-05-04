package com.example.forus.interfaces;

import com.example.forus.dto.ImageDto;
import com.example.forus.model.Imagen;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;
import retrofit2.http.Body;


public interface CRUDInterface {
    @GET("imagen")
    Call<List<Imagen>> getAll();

    @GET("imagen/{id}")
    Call<Imagen> getOne(@Path("id") int id);

    @POST("imagen")
    Call<Imagen> create(@Body ImageDto dto);
    @PUT("imagen/{id}")
    Call<Imagen> edit(@Path("id") int id, @Body ImageDto dto);

    @DELETE("imagen/{id}")
    Call<Imagen>delete(@Path(("id")) int id);
}
