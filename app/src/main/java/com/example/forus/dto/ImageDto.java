package com.example.forus.dto;

import java.io.File;


public class ImageDto {

    private int dias;
    private File img;
    private String fecha;
    private String genero;
    private String talla;

    public ImageDto(int dias, File img, String fecha, String genero, String talla) {
        this.dias = dias;
        this.img = img;
        this.fecha = fecha;
        this.genero = genero;
        this.talla = talla;
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
}
