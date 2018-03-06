package com.example.admin.tripmex;

public class Iglesias {
    String nombre;
    String ubicacion;
    String descripcion;
    Long puntuacion;
    Double latitudX;
    Double longitudY;
    Long telefono;
    String paginaWeb;
    String urlImagen;

    public Iglesias() {
    }

    public Iglesias(String nombre, String paginaWeb, Long telefono, String ubicacion, String urlImagen) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
        this.telefono = telefono;
        this.paginaWeb = paginaWeb;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPaginaWeb() {
        return paginaWeb;
    }

    public Long getTelefono() {
        return telefono;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getUrlImagen() {
        return urlImagen;
    }

    public Double getLongitudY() {
        return longitudY;
    }

    public Double getLatitudX() {
        return latitudX;
    }

    public Long getPuntuacion() {
        return puntuacion;
    }

    public String getDescripcion() {
        return descripcion;
    }


    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public void setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setUrlImagen(String urlImagen) {
        this.urlImagen = urlImagen;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setLatitudX(Double latitudX) {
        this.latitudX = latitudX;
    }

    public void setLongitudY(Double longitudY) {
        this.longitudY = longitudY;
    }

    public void setPuntuacion(Long puntuacion) {
        this.puntuacion = puntuacion;
    }
}

