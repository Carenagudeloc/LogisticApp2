package com.example.logisticAPP.services;

import com.example.logisticAPP.helpers.mensajes.MensajesError;
import com.example.logisticAPP.helpers.validations.MercanciaValidacion;
import com.example.logisticAPP.models.Commodity;
import com.example.logisticAPP.models.DTO.CommodityDTO;
import com.example.logisticAPP.models.mapas.IMapaMercancia;
import com.example.logisticAPP.repositories.ICommodityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommodityService {

    //INYECTAR LA DEPENDENCIA AL REPOSITORIO
    @Autowired
    ICommodityRepository consultaBD;

    @Autowired
    MercanciaValidacion validacion;

    @Autowired
    IMapaMercancia iMapaMercancia;

    //Registrar en la base de datos una mercancia
    public CommodityDTO registrar(Commodity datosMercancia)throws Exception{
        //verificar si las validaciones son correctas
        //Si validación pasa, podría necesitar hacer operaciones con los datos
        //Si validacion pasa, se guarda la mercancia
        //Si no pasa la validacion se responde al ciente con un mensaje de error

        try{
            if(!this.validacion.validarDescripcion(datosMercancia.getDescripcionProducto())){
                throw new Exception(MensajesError.DESCRIPCION_INVALIDA.getMensaje());
            }

            if(!this.validacion.validarPeso(datosMercancia.getPesoOcupa())){
                throw new Exception(MensajesError.PESO_INVALIDO.getMensaje());
            }

            if(!this.validacion.validarVolumen(datosMercancia.getVolumenOcupa())){
                throw new Exception(MensajesError.VOLUMEN_INVALIDO.getMensaje());
            }

            return this.iMapaMercancia.transformarMercanciaEnDTO(consultaBD.save(datosMercancia));

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Consultar la información de todas las mercancias
    public List<CommodityDTO> buscarMercanciaas()throws Exception{
        try {
            return this.iMapaMercancia.transformarVariasMercanciasEnDTO(this.consultaBD.findAll());
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    //Consultar la información de una mercancia por ID

    //Consultar la información de una mercancia por nombre

    //Modificar la información de una mercancia entregandole un ID y la nueva info

    //Eliminar una mercancia de la BD
}
