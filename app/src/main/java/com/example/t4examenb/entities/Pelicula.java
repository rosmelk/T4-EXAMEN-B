package com.example.t4examenb.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "peliculas")
public class Pelicula {
    @PrimaryKey(autoGenerate = true)
    public int id;
    public String titulo;
    public String sinopsis;
    public String urlImagen;

    public Pelicula() {
    }


    public Pelicula(int id, String titulo, String sinopsis, String urlImagen) {
        this.id = id;
        this.titulo = titulo;
        this.sinopsis = sinopsis;
        this.urlImagen =urlImagen;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }
}
