package com.example.t4examenb.services;

import com.example.t4examenb.entities.Pelicula;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface PeliculaServices {
    @GET("pelicula")
    Call<List<Pelicula>> getPelicula();
    //Guardar
    @POST("pelicula")
    Call<Pelicula> create(@Body Pelicula pelicula);

    //editar
    @PUT("pelicula/{id}")
    Call<Pelicula> editar(@Path("id") int id  , @Body Pelicula pelicula);
    //ELIMINAR
    @DELETE("pelicula/{id}")
    Call<Pelicula> eliminar(@Path("id") int id);

}
