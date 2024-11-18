package com.example.logisticAPP.models.mapas;

import com.example.logisticAPP.models.Commodity;
import com.example.logisticAPP.models.DTO.CommodityDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IMapaMercancia {

    @Mappings({
            @Mapping(source = "volumenOcupa", target = "volumenOcupa"),
            @Mapping(source = "pesoOcupa", target = "pesoOcupa"),
            @Mapping(source = "nombreProducto", target = "nombreProducto"),
            @Mapping(source = "fechaEntrada", target = "fechaEntrada")

    })

    //Creo los metodos que necesiten ser mapeados
    CommodityDTO transformarMercanciaEnDTO(Commodity mercancia);
    List<CommodityDTO> transformarVariasMercanciasEnDTO(List<Commodity> mercancias);


}
