package com.backend.forUsBack.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.awt.*;
import java.io.File;
import java.io.Serializable;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class Imagen {

    private int id;
    private int dias;

    private File img;

    private String fecha;
    private String genero;
    private String talla;

}
