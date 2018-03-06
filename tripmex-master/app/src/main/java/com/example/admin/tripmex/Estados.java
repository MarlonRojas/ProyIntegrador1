package com.example.admin.tripmex;

/**
 * Created by IMT on 26/10/2017.
 */

public class Estados {
    String nombre;
    String imagenEstado;

    public Estados(){
    }

    public Estados(String nombre, String imagenEstado){
        this.nombre = nombre;
        this.imagenEstado = imagenEstado;
    }

    public String getImagenEstado() {
        return imagenEstado;
    }

    public String getNombre() {
        return nombre;
    }

    public void setImagenEstado(String imagenEstado) {
        this.imagenEstado = imagenEstado;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

