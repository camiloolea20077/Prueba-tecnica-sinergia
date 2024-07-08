package com.prueba.inicio.model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@jakarta.persistence.Entity
public class Bodega {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String ubicacion;

    public Long getId(){
        return id;
    }
    public String getNombre(){
        return nombre;
    }
    public String getUbicacion(){
        return ubicacion;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNombre(String nombre){
        this.nombre=nombre;
    }
    public void setUbicacion(String ubicacion){
        this.ubicacion=ubicacion;
    }
}
