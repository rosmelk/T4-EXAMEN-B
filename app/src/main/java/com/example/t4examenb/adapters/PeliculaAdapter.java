package com.example.t4examenb.adapters;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.room.Room;

import com.example.t4examenb.R;
import com.example.t4examenb.RetroFactory.RetroFactory;
import com.example.t4examenb.VerDetalle;
import com.example.t4examenb.dao.PeliculaDAO;
import com.example.t4examenb.database.AppDataBase;
import com.example.t4examenb.entities.Pelicula;
import com.example.t4examenb.services.PeliculaServices;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class PeliculaAdapter extends RecyclerView.Adapter <PeliculaAdapter.ViewHolderPelicula>  {


    List<Pelicula> pelicula;
    public PeliculaAdapter(List<Pelicula> pelicula) {
        this.pelicula = pelicula;
    }

    @NonNull
    @Override
    public ViewHolderPelicula onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rc_layaut,parent,false);
        return new ViewHolderPelicula(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderPelicula vh, int position) {
      View itemView =vh.itemView;
        Pelicula peliculas = pelicula.get(position);
        //ImageView tvImagen = itemView.findViewById(R.id.tvImagen);
        TextView txtTitulo = itemView.findViewById(R.id.tvTitulo);
        TextView txtSinopsis= itemView.findViewById(R.id.tvSinopsis);
        TextView textId = itemView.findViewById(R.id.tvid);


        //Picasso.get().load(peliculas.urlImagen).into(tvImagen);
        txtTitulo.setText(peliculas.titulo);
        txtSinopsis.setText(peliculas.sinopsis);
        textId.setText(Integer.toString( peliculas.id));


        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(itemView.getContext(), VerDetalle.class);
                String peliculaJSON = new Gson().toJson(peliculas);
                intent.putExtra("DATOS",peliculaJSON);
                itemView.getContext().startActivity(intent);
            }
        });



    }


    @Override
    public int getItemCount() {
        return pelicula.size();
    }

    public class ViewHolderPelicula extends RecyclerView.ViewHolder  {

        public ViewHolderPelicula(@NonNull View itemView) {
            super(itemView);


        }



    }
}
