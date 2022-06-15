package com.example.t4examenb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.t4examenb.RetroFactory.RetroFactory;
import com.example.t4examenb.adapters.PeliculaAdapter;
import com.example.t4examenb.dao.PeliculaDAO;
import com.example.t4examenb.database.AppDataBase;
import com.example.t4examenb.entities.Pelicula;
import com.example.t4examenb.services.PeliculaServices;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    AppDataBase db;
    PeliculaDAO dao;
    private List<Pelicula>peliculas = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatingActionButton fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), RegistroPelicula.class);
                startActivity(intent);
            }
        });

        db = AppDataBase.getDataBase(getApplicationContext());
        dao = db.peliculaDAO();

        Pelicula pelicula = new Pelicula();
        Pelicula pelicula2 = new Pelicula();
        Pelicula pelicula3 = new Pelicula();
        Pelicula pelicula4 = new Pelicula();
        pelicula.titulo = "BanDame";
        pelicula.sinopsis="Es una pelicula de terror hecho en Japon";
        //pelicula.urlImagen="https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png";
        pelicula2.titulo = "Simpson";
        pelicula2.sinopsis="Es una pelicula de terror hecho en Japon";
        //pelicula.urlImagen="https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png";
        pelicula3.titulo = "NuevaVentura";
        pelicula3.sinopsis="Es una pelicula de terror hecho en Japon";
        //pelicula.urlImagen="https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png";
        pelicula4.titulo = "Unzone";
        pelicula4.sinopsis="Es una pelicula de terror hecho en Japon";
        //pelicula.urlImagen="https://assets.pokemon.com/assets/cms2/img/pokedex/full/005.png";

        dao.create(pelicula);
        dao.create(pelicula2);
        dao.create(pelicula3);
        dao.create(pelicula4);
        peliculas =db.peliculaDAO().getAll();
        PeliculaAdapter peliculaAdapter = new PeliculaAdapter(peliculas);
        RecyclerView rv = findViewById(R.id.rvLista);
        rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        rv.setHasFixedSize(true);
        rv.setAdapter(peliculaAdapter);


        Retrofit retrofit = RetroFactory.build();
        PeliculaServices services = retrofit.create(PeliculaServices.class);
        Call<List<Pelicula>> call = services.getPelicula();
        call.enqueue(new Callback<List<Pelicula>>() {
            @Override
            public void onResponse(Call<List<Pelicula>> call, Response<List<Pelicula>> response) {
                if(!response.isSuccessful()) {
                    Log.e("APP_VJ20202", "Error de aplicación");
                }
                else {
                    Log.i("APP_VJ20202", "Respuesta Correcta");
                    peliculas = response.body();

                    saveIndata(peliculas);
                    Log.i("APP_VJ20202", new Gson().toJson(peliculas));
                    Toast.makeText(getApplicationContext(), "SICRONIZACION CORRECTAMENTE", Toast.LENGTH_LONG).show();

                }

            }

            @Override
            public void onFailure(Call<List<Pelicula>> call, Throwable t) {

            }
        });


    }

    private void saveIndata(List<Pelicula>  peliculas){

        PeliculaDAO dao = db.peliculaDAO();
        for( Pelicula anime1: peliculas) {
            dao.create(anime1);
        }

    }




}

