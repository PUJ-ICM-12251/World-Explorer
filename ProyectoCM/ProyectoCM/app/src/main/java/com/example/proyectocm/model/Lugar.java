package com.example.proyectocm.model;

import android.provider.MediaStore;

public class Lugar {
    String nombre;

    double latitud;

    double longitud;
    MediaStore.Images imagen;

    public Lugar(String nombre, double latitud, double longitud, MediaStore.Images imagen){
        this.nombre = nombre;
        this.latitud = latitud;
        this.longitud = longitud;
        this.imagen = imagen;
    }

    public double getLatitud(){
        return this.latitud;
    }

    public double getLongitud(){
        return this.longitud;
    }

    public String getnombre(){
        return this.nombre;
    }
}
