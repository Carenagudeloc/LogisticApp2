package com.example.logisticAPP.controllers;


import com.example.logisticAPP.models.Commodity;
import com.example.logisticAPP.models.DTO.CommodityDTO;
import com.example.logisticAPP.services.CommodityService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("logisticApp/v1/mercancias") //endpoint orientado al recurso
@Tag(name="Servicios mercancias en bodega", description = "\nServicios asociados a la tabla mercancias de la bd, se hace CRUD completo")
public class MercanciaControlador {

    //inyectar una dependencia al servicio
    @Autowired
    CommodityService mercanciaServicio;

    @PostMapping
    @Operation(
            summary = "Registra una mercancia en la base de datos",
            description = "Se envia un objeto que responde al modelo mercancia y se retorna un DTO con los datos" +
                    " de la mercancia almacenada"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Mercancia guardada con exito en la bd",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CommodityDTO.class),
                                    examples = @ExampleObject(value = "{\"volumenOcupa\":\"30.4\",\"pesoOcupa\":\"400\",\"nombre\":\"Televisor SONY\"," +
                                            "\"fechaEntrada\":\"2024-10-10\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error al registrar la mercancia",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            } // Aquí se cerró correctamente el array
    ) // Y aquí se cierra la anotación @ApiResponses

    //Se crea un método para llamar a cada uno de los servicios disponibles
     public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody Commodity datosMercancia){
         try {
             return ResponseEntity.status(HttpStatus.CREATED).body(this.mercanciaServicio.registrar(datosMercancia));

         } catch (Exception error) {
             //El hashMap nos permite responder con un mensaje de error
             HashMap<String, Object> respuestError = new HashMap<>();
             respuestError.put("mensaje", error.getMessage());
             return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
         }
     }

     @GetMapping
     public ResponseEntity<?> llamandoAlServicioParaBuscarTodas(){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(this.mercanciaServicio.buscarMercanciaas());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
     }
}
