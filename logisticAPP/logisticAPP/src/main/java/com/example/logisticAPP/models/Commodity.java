package com.example.logisticAPP.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table (name = "mercancias")
public class Commodity {

    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //iup
    private Integer iup;

    @Column(name = "volumen_ocupado", nullable = false)
    //volumenOcupa
    private double volumenOcupa;

    @Column (name = "peso_ocupa", nullable = false)
    //pesoOcupa
    private double pesoOcupa;

    @Column (name = "nombre", nullable = false)
    //nombre
    private String nombreProducto;

    @Column (name = "descripcion")
    //descripcion
    private String descripcionProducto;

    @Column (name = "fecha_entrada", nullable = false)
    //fechaEntrada
    private LocalDate fechaEntrada;

    @Column (name = "fecha_salida")
    //fechaSalida
    private LocalDate fechaSalida;

    //Las relaciones no son mas que nuevos atributos
    //Siempre el atributo será la tabla con la que me voy a relacionar

    @ManyToOne
    @JoinColumn(name="fk_zonaBodega", referencedColumnName = "idZona")
    @JsonBackReference
    private  StoreZone storeZone;




    public Commodity() {
    }

    public Commodity(Integer iup, double volumenOcupa, double pesoOcupa, String nombreProducto, String descripcionProducto, LocalDate fechaEntrada, LocalDate fechaSalida) {
        this.iup = iup;
        this.volumenOcupa = volumenOcupa;
        this.pesoOcupa = pesoOcupa;
        this.nombreProducto = nombreProducto;
        this.descripcionProducto = descripcionProducto;
        this.fechaEntrada = fechaEntrada;
        this.fechaSalida = fechaSalida;
    }

    public Integer getIup() {
        return iup;
    }

    public void setIup(Integer iup) {
        this.iup = iup;
    }

    public double getVolumenOcupa() {
        return volumenOcupa;
    }

    public void setVolumenOcupa(double volumenOcupa) {
        this.volumenOcupa = volumenOcupa;
    }

    public double getPesoOcupa() {
        return pesoOcupa;
    }

    public void setPesoOcupa(double pesoOcupa) {
        this.pesoOcupa = pesoOcupa;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public void setNombreProducto(String nombreProducto) {
        this.nombreProducto = nombreProducto;
    }

    public String getDescripcionProducto() {
        return descripcionProducto;
    }

    public void setDescripcionProducto(String descripcionProducto) {
        this.descripcionProducto = descripcionProducto;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public void setFechaEntrada(LocalDate fechaEntrada) {
        this.fechaEntrada = fechaEntrada;
    }

    public LocalDate getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(LocalDate fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    //remitente
    //destinatario
    //zonaUbicacionBodega
}
