package com.example.logisticAPP.models.DTO;

import java.time.LocalDate;

public class CommodityDTO {
    //Devolver solo: Volumen, peso, nombre, fechaEntrada

    private Double volumenOcupa;

    private  Double pesoOcupa;

    private String nombreProducto;

    private LocalDate fechaEntrada;

    public CommodityDTO() {
    }

    public CommodityDTO(Double volumenOcupa, Double pesoOcupa, String nombreProducto, LocalDate fechaEntrada) {
        this.volumenOcupa = volumenOcupa;
        this.pesoOcupa = pesoOcupa;
        this.nombreProducto = nombreProducto;
        this.fechaEntrada = fechaEntrada;
    }

    public Double getVolumenOcupa() {
        return volumenOcupa;
    }

    public void setVolumenOcupa(Double volumenOcupa) {
        this.volumenOcupa = volumenOcupa;
    }

    public Double getPesoOcupa() {
        return pesoOcupa;
    }

    public void setPesoOcupa(Double pesoOcupa) {
        this.pesoOcupa = pesoOcupa;
    }


    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }
}
