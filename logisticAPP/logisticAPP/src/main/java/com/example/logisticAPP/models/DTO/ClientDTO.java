package com.example.logisticAPP.models.DTO;

public class ClientDTO {

    private String nombreCliente;
    private String departamentoCliente;
    private String municipioCliente;
    private String direccionCliente;
    private String correoCliente;
    private Double telefonoCliente;

    public ClientDTO() {
    }

    public ClientDTO(String nombreCliente, String departamentoCliente, String municipioCliente, String direccionCliente, String correoCliente, Double telefonoCliente) {
        this.nombreCliente = nombreCliente;
        this.departamentoCliente = departamentoCliente;
        this.municipioCliente = municipioCliente;
        this.direccionCliente = direccionCliente;
        this.correoCliente = correoCliente;
        this.telefonoCliente = telefonoCliente;
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