package com.example.ProyectoFinal_BackEnd.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Users {
    @Id
    @GeneratedValue( strategy = GenerationType.AUTO)
    private Integer id;
    private String email;
    private String password;
    private  String role;
}
