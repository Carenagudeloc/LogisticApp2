package com.example.logisticAPP.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table (name = "cliente")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    //id
    private Integer idCliente;

    @Column(name = "nombre_cliente", nullable = false)
    //nombres
    private String nombreCliente;

    @Column(name = "departamento_cliente", nullable = false)
    //departamento
    private String departamentoCliente;

    @Column(name = "municipio_cliente", nullable = false)
    //municipio
    private String municipioCliente;

    @Column(name = "direccion_cliente", nullable = false)
    //direccion
    private String direccionCliente;

    @Column(name = "codigo_postal", nullable = false)
    //codPostal
    private String codigoPostalCliente;

    @Column(name = "rol", nullable = false)
    //rol
    private String rolCliente;

    @Column(name = "correo", nullable = false)
    //correo
    private String correoCliente;

    @Column(name = "telefono", nullable = false)
    //telefono
    private Double telefonoCliente;



    public Client() {
    }

    public Client(Integer idCliente, String nombreCliente, String departamentoCliente, String municipioCliente, String direccionCliente, String codigoPostalCliente, String rolCliente, String correoCliente, Double telefonoCliente) {
        this.idCliente = idCliente;
        this.nombreCliente = nombreCliente;
        this.departamentoCliente = departamentoCliente;
        this.municipioCliente = municipioCliente;
        this.direccionCliente = direccionCliente;
        this.codigoPostalCliente = codigoPostalCliente;
        this.rolCliente = rolCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getDepartamentoCliente() {
        return departamentoCliente;
    }

    public void setDepartamentoCliente(String departamentoCliente) {
        this.departamentoCliente = departamentoCliente;
    }

    public String getMunicipioCliente() {
        return municipioCliente;
    }

    public void setMunicipioCliente(String municipioCliente) {
        this.municipioCliente = municipioCliente;
    }

    public String getDireccionCliente() {
        return direccionCliente;
    }

    public void setDireccionCliente(String direccionCliente) {
        this.direccionCliente = direccionCliente;
    }

    public String getCodigoPostalCliente() {
        return codigoPostalCliente;
    }

    public void setCodigoPostalCliente(String codigoPostalCliente) {
        this.codigoPostalCliente = codigoPostalCliente;
    }

    public String getRolCliente() {
        return rolCliente;
    }

    public void setRolCliente(String rolCliente) {
        this.rolCliente = rolCliente;
    }

    public String getCorreoCliente() {
        return correoCliente;
    }

    public void setCorreoCliente(String correoCliente) {
        this.correoCliente = correoCliente;
    }

    public Double getTelefonoCliente() {
        return telefonoCliente;
    }

    public void setTelefonoCliente(Double telefonoCliente) {
        this.telefonoCliente = telefonoCliente;
    }
}
