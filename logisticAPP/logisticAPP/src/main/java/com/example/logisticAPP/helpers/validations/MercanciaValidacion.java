package com.example.logisticAPP.helpers.validations;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Component
public class MercanciaValidacion {

    //Validar que volumen solo sea positivo
    public boolean validarVolumen(Double volumen){
        return volumen>0?true:false;
    }

    //Validar que peso solo sea positivo
    public boolean validarPeso(Double peso){
        return peso>0?true:false;
    }

    //La descripcion solo puede tener hasta 200 caracteres
    public boolean validarDescripcion(String descripcion){
        return descripcion.length()<200?true:false;
    }

    //Las fechas deben tener el formato (mm-dd-yyyy)
    public boolean validarFormatoFecha(LocalDate fecha){
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fechaLocalDate = LocalDate.parse(fecha.toString(), formato);
        return fechaLocalDate.format(formato).equals(fecha.toString());

    }

}
