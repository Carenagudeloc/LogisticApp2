package com.example.logisticAPP.services;


import com.example.logisticAPP.helpers.mensajes.MensajesError;
import com.example.logisticAPP.helpers.validations.ZonasBodegaValidacion;
import com.example.logisticAPP.models.Client;
import com.example.logisticAPP.models.StoreZone;
import com.example.logisticAPP.repositories.IStoreZoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreZoneServices {

    @Autowired
    IStoreZoneRepository consultaBD;

    @Autowired
    ZonasBodegaValidacion validacion;

    public StoreZone registrar (StoreZone datosZonaBodega) throws Exception {
        try {
            if(!this.validacion.validarNombreZona(datosZonaBodega.getNombreZona())){
                throw new Exception(MensajesError.NOMBREZONA_INVALIDO.getMensaje());
            }

            if(!this.validacion.validarVolumenMaximo(datosZonaBodega.getVolumenMaximo())){
                throw new Exception(MensajesError.VOLUMEN_INVALIDO.getMensaje());
            }

            if (!this.validacion.validarPesoMaximo(datosZonaBodega.getPesoMaximo())){
                throw new Exception(MensajesError.PESO_INVALIDO.getMensaje());
            }

            /*if(!this.validacion.validarVolumenOcupado(datosZonaBodega.getVolumenOcupado())){
                throw new Exception(MensajesError.VOLUMENOCUPADO_INVALIDO.getMensaje());
            }

            if (!this.validacion.validarPesoOcupado(datosZonaBodega.getPesoOcupado())){
                throw new Exception(MensajesError.PESOOCUPADO_INVALIDO.getMensaje());
            }*/

            return this.consultaBD.save(datosZonaBodega);

        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<StoreZone> buscarMercancias()throws Exception{
        try {
            return this.consultaBD.findAll();
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

}
