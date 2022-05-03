package com.backend.forUsBack.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import com.backend.forUsBack.dto.ImagenDTO;
import com.backend.forUsBack.model.Imagen;

import javax.imageio.ImageIO;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping("/imagen")
public class ImagenController {

    //File file = new File("/src/main/resources/static/pants.png");

    private List<Imagen> closeth = new ArrayList<>(Arrays.asList(new Imagen(1,2,null,"2/2/2021","M","S"),
            new Imagen(3,5,null,"3/5/2021","M","S")));

    @GetMapping
    public ResponseEntity<List<Imagen>> getAll() {
        return ResponseEntity.ok(closeth);
    }

    @GetMapping("{id}")
    public ResponseEntity<Imagen> getOne(@PathVariable("id") int id) {
        Imagen img = findById(id);
        return ResponseEntity.ok(img);
    }

    @PostMapping
    public ResponseEntity<Imagen> create(@RequestBody ImagenDTO dto) {
        int index = closeth.isEmpty()? 1 : getLastIndex() + 1;
        Imagen prenda = Imagen.builder().id(index).dias(dto.getDias()).img(dto.getImg()).fecha(dto.getFecha()).genero(dto.getGenero()).talla(dto.getTalla()).build();
        closeth.add(prenda);
        return ResponseEntity.ok(prenda);
    }

    @PutMapping("{id}")
    public ResponseEntity<Imagen> update(@PathVariable("id") int id, @RequestBody ImagenDTO dto) {
        Imagen prenda = findById(id);
        prenda.setDias(dto.getDias());
        prenda.setImg(dto.getImg());
        prenda.setFecha(dto.getFecha());
        prenda.setGenero(dto.getGenero());
        prenda.setTalla(dto.getTalla());
        return ResponseEntity.ok(prenda);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Imagen> delete(@PathVariable("id") int id) {
        Imagen prenda = findById(id);
        closeth.remove(prenda);
        return ResponseEntity.ok(prenda);
    }

    private int getLastIndex() {
        return closeth.stream().max(Comparator.comparing(Imagen::getId)).get().getId();
    }

    private Imagen findById(int id) {
        return closeth.stream().filter(p -> p.getId() == id).findAny().orElse(null);
    }


}
