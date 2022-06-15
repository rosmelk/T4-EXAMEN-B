package com.example.t4examenb;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.t4examenb.RetroFactory.RetroFactory;
import com.example.t4examenb.entities.Pelicula;
import com.example.t4examenb.services.PeliculaServices;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class RegistroPelicula extends AppCompatActivity {

    EditText tTitulo;
    EditText tSinopsis;
    EditText tImagen;
    Call<Pelicula>call;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_pelicula);

       tTitulo = findViewById(R.id.tTitulo);
       tSinopsis = findViewById(R.id.tSinopsis);
       tImagen= findViewById(R.id.tImagen);

        Button btnGuardar = findViewById(R.id.btnGuardar);
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Retrofit retrofit = RetroFactory.build();
                PeliculaServices service = retrofit.create(PeliculaServices.class);
                Pelicula pelicula = new Pelicula();

                pelicula.titulo = String.valueOf(tTitulo.getText());
                pelicula.sinopsis = String.valueOf(tSinopsis.getText());
                pelicula.urlImagen = String.valueOf(tImagen.getText());

                call = service.create(pelicula);
                Toast.makeText(getApplicationContext(), "Se guardo los datos correctamente", Toast.LENGTH_LONG).show();
                call.enqueue(new Callback<Pelicula>() {
                    @Override
                    public void onResponse(Call<Pelicula> call, Response<Pelicula> response) {

                        if (response.isSuccessful()){
                            Log.e("APP", new Gson().toJson(response.body()));

                        }
                    }

                    @Override
                    public void onFailure(Call<Pelicula> call, Throwable t) {

                    }
                });

            }
        });

    }
}