package com.example.logisticAPP.models.DTO;

public class StoreZoneDTO {

    private Integer idZona;

    private String nombreZona;

    private Double volumenMaximo;

    private  Double pesoMaximo;

    private Double volumenOcupa;

    private  Double pesoOcupa;

    public StoreZoneDTO() {
    }

    public StoreZoneDTO(Integer idZona, String nombreZona, Double volumenMaximo, Double pesoMaximo) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.volumenMaximo = volumenMaximo;
        this.pesoMaximo = pesoMaximo;
    }

    public StoreZoneDTO(Integer idZona, String nombreZona, Double volumenMaximo, Double pesoMaximo, Double pesoOcupa, Double volumenOcupa) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.volumenMaximo = volumenMaximo;
        this.pesoMaximo = pesoMaximo;
        this.pesoOcupa= pesoOcupa;
        this.volumenOcupa= volumenOcupa;

    }

    public Integer getIdZona() {
        return idZona;
    }

    public void setIdZona(Integer idZona) {
        this.idZona = idZona;
    }

    public String getNombreZona() {
        return nombreZona;
    }

    public void setNombreZona(String nombreZona) {
        this.nombreZona = nombreZona;
    }

    public Double getVolumenMaximo() {
        return volumenMaximo;
    }

    public void setVolumenMaximo(Double volumenMaximo) {
        this.volumenMaximo = volumenMaximo;
    }

    public Double getPesoMaximo() {
        return pesoMaximo;
    }

    public void setPesoMaximo(Double pesoMaximo) {
        this.pesoMaximo = pesoMaximo;
    }

    public Double getPesoOcupa() {
        return pesoOcupa;
    }

    public void setPesoOcupa(Double pesoOcupa) {
        this.pesoOcupa = pesoOcupa;
    }

    public Double getVolumenOcupa() {
        return volumenOcupa;
    }

    public void setVolumenOcupa(Double volumenOcupa) {
        this.volumenOcupa = volumenOcupa;
    }
}
