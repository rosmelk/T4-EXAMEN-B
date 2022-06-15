package com.example.t4examenb;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.t4examenb.RetroFactory.RetroFactory;
import com.example.t4examenb.adapters.PeliculaAdapter;
import com.example.t4examenb.dao.PeliculaDAO;
import com.example.t4examenb.database.AppDataBase;
import com.example.t4examenb.entities.Pelicula;
import com.example.t4examenb.services.PeliculaServices;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class VerDetalle extends AppCompatActivity {
    EditText eTitulo;
    EditText eSinopsis;
    EditText eImagen;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ver_detalle);
        eTitulo =findViewById(R.id.eTitulo);
        eSinopsis =findViewById(R.id.eSinopsis);
        eImagen =findViewById(R.id.eImagen);




        String animeJSON = getIntent().getStringExtra("DATOS");
        Pelicula pelicula = new Gson().fromJson(animeJSON, Pelicula.class);

        eTitulo.setText(pelicula.titulo);
        eSinopsis.setText(pelicula.sinopsis);
        eImagen.setText(pelicula.urlImagen);



    }





}