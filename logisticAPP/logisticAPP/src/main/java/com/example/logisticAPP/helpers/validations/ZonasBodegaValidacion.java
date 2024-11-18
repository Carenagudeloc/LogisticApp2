package com.example.logisticAPP.helpers.validations;

import org.springframework.stereotype.Component;

@Component
public class ZonasBodegaValidacion {

    public boolean validarNombreZona(String nombre){
        return nombre.length()<=50?true:false;
    }

    public boolean validarVolumenMaximo(Double volumenMaximo){
        return volumenMaximo>=0?true:false;
    }

    public boolean validarPesoMaximo(Double pesoMaximo){
        return pesoMaximo>=0?true:false;
    }

    /*public boolean validarVolumenOcupado(Double volumenOcupado){
        return volumenOcupado>=0?true:false;
    }

    public boolean validarPesoOcupado(Double pesoOcupado){
        return pesoOcupado>0?true:false;
    }
*/


}
