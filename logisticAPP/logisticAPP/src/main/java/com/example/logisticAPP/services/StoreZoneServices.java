package com.example.logisticAPP.services;


import com.example.logisticAPP.helpers.mensajes.MensajesError;
import com.example.logisticAPP.helpers.validations.ZonasBodegaValidacion;
import com.example.logisticAPP.models.Client;
import com.example.logisticAPP.models.StoreZone;
import com.example.logisticAPP.repositories.IStoreZoneRepository;
import jakarta.transaction.Transactional;
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

    @Transactional
    public StoreZone ingresarProductoEnZona(Integer idZona, Double pesoProducto, Double volumenProducto) throws Exception {
            // Buscar la zona de bodega por id
            StoreZone zona = consultaBD.findById(idZona)
                    .orElseThrow(() -> new Exception("Zona no encontrada"));
            if (pesoProducto <= 0 || volumenProducto <= 0) {
                throw new Exception("Peso o volumen inválido");
            }
            // Validar límites
            if (zona.getPesoOcupado() + pesoProducto > zona.getPesoMaximo()) {
                throw new Exception("El peso excede el máximo permitido en la zona");
            }
            if (zona.getVolumenOcupado() + volumenProducto > zona.getVolumenMaximo()) {
                throw new Exception("El volumen excede el máximo permitido en la zona");
            }
            // Actualizar peso y volumen ocupados
            zona.setPesoOcupado(zona.getPesoOcupado() + pesoProducto);
            zona.setVolumenOcupado(zona.getVolumenOcupado() + volumenProducto);
            // Guardar los cambios
            consultaBD.save(zona);
            // Calcular peso y volumen restantes
            Double pesoRestante = zona.getPesoMaximo() - zona.getPesoOcupado();
            Double volumenRestante = zona.getVolumenMaximo() - zona.getVolumenOcupado();
            // Agregar al modelo y devolver
            zona.setPesoRestante(pesoRestante);   // Debes agregar este atributo en la clase StoreZone
            zona.setVolumenRestante(volumenRestante);
            return zona;
    }

}

