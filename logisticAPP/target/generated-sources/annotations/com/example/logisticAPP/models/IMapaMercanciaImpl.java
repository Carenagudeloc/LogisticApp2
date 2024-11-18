package com.example.logisticAPP.models;

import com.example.logisticAPP.models.DTO.CommodityDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-08T11:12:20-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 22.0.1 (Oracle Corporation)"
)
@Component
public class IMapaMercanciaImpl implements IMapaMercancia {

    @Override
    public CommodityDTO transformarMercanciaEnDTO(Commodity mercancia) {
        if ( mercancia == null ) {
            return null;
        }

        CommodityDTO commodityDTO = new CommodityDTO();

        commodityDTO.setVolumenOcupa( mercancia.getVolumenOcupa() );
        commodityDTO.setPesoOcupa( mercancia.getPesoOcupa() );
        commodityDTO.setNombreProducto( mercancia.getNombreProducto() );
        commodityDTO.setFechaEntrada( mercancia.getFechaEntrada() );

        return commodityDTO;
    }

    @Override
    public List<CommodityDTO> transformarVariasMercanciasEnDTO(List<Commodity> mercancias) {
        if ( mercancias == null ) {
            return null;
        }

        List<CommodityDTO> list = new ArrayList<CommodityDTO>( mercancias.size() );
        for ( Commodity commodity : mercancias ) {
            list.add( transformarMercanciaEnDTO( commodity ) );
        }

        return list;
    }
}
