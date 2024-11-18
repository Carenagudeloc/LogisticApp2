package com.example.logisticAPP.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "zonas_bodega")
public class StoreZone {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //idZona
    private Integer idZona;

    @Column(name = "nombre_zona", nullable = false)
    //nombreZona
    private String nombreZona; //maximo 50 caracteres

    @Column(name = "volumen_maximo", nullable = false)
    //volumenMaximo
    private Double volumenMaximo; //solo positivos

    @Column(name = "peso_maximo", nullable = false)
    //pesoMaximo
    private  Double pesoMaximo; // solo positivos

    //@Column(name = "volumen_ocupado", nullable = false)
    //volumenOcupado
    //private  Double volumenOcupado; //solo positivos

    //@Column(name = "peso_ocupado", nullable = false)
    //pesoOcupado
    //private  Double pesoOcupado = 0.0; //solo positivos

    @OneToMany(mappedBy = "storeZone")
    @JsonManagedReference
    private List<Commodity> commodityList;
    public StoreZone() {
    }



    public StoreZone(Integer idZona, String nombreZona, Double volumenMaximo, Double pesoMaximo) {
        this.idZona = idZona;
        this.nombreZona = nombreZona;
        this.volumenMaximo = volumenMaximo;
        this.pesoMaximo = pesoMaximo;
        //this.volumenOcupado = volumenOcupado;
        //this.pesoOcupado = pesoOcupado;
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

    /*public Double getVolumenOcupado() {
        return volumenOcupado;
    }

    public void setVolumenOcupado(Double volumenOcupado) {
        this.volumenOcupado = volumenOcupado;
    }

    public Double getPesoOcupado() {
        return pesoOcupado;
    }

    public void setPesoOcupado(Double pesoOcupado) {
        this.pesoOcupado = pesoOcupado;
    }*/
}
