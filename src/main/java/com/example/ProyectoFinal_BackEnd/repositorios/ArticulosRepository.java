package com.example.ProyectoFinal_BackEnd.repositorios;

import com.example.ProyectoFinal_BackEnd.entidades.Articulos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ArticulosRepository extends JpaRepository<Articulos, Integer> {
}
