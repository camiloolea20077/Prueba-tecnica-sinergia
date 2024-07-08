package com.prueba.inicio.model;


import java.time.LocalDate;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@jakarta.persistence.Entity
public class EnvioMaritimo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipoProducto;
    private int cantidad;
    private LocalDate fechaRegistro;
    private LocalDate fechaEntrega;
    @ManyToOne
    private Puerto puertoEntrega;
    private double precioEnvio;
    private String numeroFlota;
    private String numeroGuia;
    @ManyToOne
    private Cliente cliente;

    // Getters
    public Long getId() {
        return id;
    }

    public String getTipoProducto() {
        return tipoProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public LocalDate getFechaRegistro() {
        return fechaRegistro;
    }

    public LocalDate getFechaEntrega() {
        return fechaEntrega;
    }

    public Puerto getPuertoEntrega() {
        return puertoEntrega;
    }

    public double getPrecioEnvio() {
        return precioEnvio;
    }

    public String getNumeroFlota() {
        return numeroFlota;
    }

    public String getNumeroGuia() {
        return numeroGuia;
    }

    public Cliente getCliente() {
        return cliente;
    }
     // Setters
     public void setId(Long id) {
        this.id = id;
    }

    public void setTipoProducto(String tipoProducto) {
        this.tipoProducto = tipoProducto;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setFechaRegistro(LocalDate fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public void setFechaEntrega(LocalDate fechaEntrega) {
        this.fechaEntrega = fechaEntrega;
    }

    public void setPuertoEntrega(Puerto puertoEntrega) {
        this.puertoEntrega = puertoEntrega;
    }

    public void setPrecioEnvio(double precioEnvio) {
        this.precioEnvio = precioEnvio;
    }

    public void setNumeroFlota(String numeroFlota) {
        this.numeroFlota = numeroFlota;
    }

    public void setNumeroGuia(String numeroGuia) {
        this.numeroGuia = numeroGuia;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}