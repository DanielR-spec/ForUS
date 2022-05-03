package com.example.forus.model;

import androidx.annotation.NonNull;

import java.io.File;

public class Image {

    private int id;
    private int dias;

    private File img;

    private String fecha;
    private String genero;
    private String talla;

    public Image() {

    }

    public Image(int id, int dias, File img, String fecha, String genero, String talla) {
        this.id = id;
        this.dias = dias;
        this.img = img;
        this.fecha = fecha;
        this.genero = genero;
        this.talla = talla;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getTalla() {
        return talla;
    }

    public void setTalla(String talla) {
        this.talla = talla;
    }

    @Override
    public String toString() {
        return "Id: " + getId() +
                "Dias: " + getDias() +
                "Ruta img: " + getImg() +
                "Fecha: " + getFecha() +
                "Genero: " + getGenero() +
                "Talla" + getTalla();
    }
}
