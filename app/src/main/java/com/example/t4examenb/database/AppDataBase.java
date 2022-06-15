package com.example.t4examenb.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.t4examenb.dao.PeliculaDAO;
import com.example.t4examenb.entities.Pelicula;

@Database(entities = {Pelicula.class}, version = 2)
public abstract class AppDataBase extends RoomDatabase {

    public abstract PeliculaDAO peliculaDAO();
    //llamamos a la bd
    public static AppDataBase getDataBase(Context context){
        return Room.databaseBuilder(context, AppDataBase.class, "db_pelicula").allowMainThreadQueries()
                .build();
    }


}