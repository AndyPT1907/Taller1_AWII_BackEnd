package com.example.ProyectoFinal_BackEnd.Controlador;

import com.example.ProyectoFinal_BackEnd.entidades.Articulos;
import com.example.ProyectoFinal_BackEnd.repositorios.ArticulosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ArticulosControler {
    @Autowired
    ArticulosRepository articulosRepository;

    ///// GET
    @GetMapping("/articulos")
    public List<Articulos> articulos(){
        //  List <Autor> autores = autorRepository.findAll();
        return articulosRepository.findAll();
    }

    @GetMapping("/articulos/{id}")
    public Optional<Articulos> autores(@PathVariable int id){
        //  List <Autor> autores = autorRepository.findAll();
        return articulosRepository.findById(id);
    }
    //// POST
    @PostMapping("/articulos")
    public Articulos crear(@RequestBody Articulos articulos){
        return articulosRepository.save(articulos);
    }

    //////  DELETE
    @DeleteMapping("/articulos/{id}")
    public ResponseEntity<Boolean> eliminarArticulo(@PathVariable int id){
        Optional <Articulos> articulos = articulosRepository.findById(id);
        articulosRepository.delete(articulos.get());
        return ResponseEntity.ok(true);
    }

    /////// PUT
    @PutMapping("/articulos/{id}")
    public  ResponseEntity <Articulos> actualizarAutor(@PathVariable int id, @RequestBody Articulos articulosData){
        Optional <Articulos> opcionalArticulos = articulosRepository.findById(id);

        Articulos articulos = opcionalArticulos.get();
        //actualizar
        articulos.setNombre( articulosData.getNombre() );
        articulos.setPrecio( articulosData.getPrecio());
        articulos.setUrl( articulosData.getUrl());

        Articulos articuloGuardado = articulosRepository.save(articulos);
        return ResponseEntity.ok(articuloGuardado);

    }

}
