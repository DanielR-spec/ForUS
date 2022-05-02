package com.backend.forUsBack.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.File;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class ImagenDTO {

    private int dias;
    private File img;
    private String fecha;
    private String genero;
    private String talla;
}
