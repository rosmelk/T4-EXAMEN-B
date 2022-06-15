package com.example.t4examenb.dao;
import static androidx.room.OnConflictStrategy.IGNORE;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import com.example.t4examenb.entities.Pelicula;
import java.util.List;

@Dao
public interface PeliculaDAO {

    @Query("SELECT * FROM peliculas")
    List<Pelicula> getAll();

    //obtener datos por ID
    @Query("SELECT * FROM  peliculas WHERE id= :id")
    Pelicula find(int id);

    //crear datos

    @Insert(onConflict = IGNORE)
    void create (Pelicula pelicula);

    @Delete
    void eliminar(Pelicula pelicula);



}
