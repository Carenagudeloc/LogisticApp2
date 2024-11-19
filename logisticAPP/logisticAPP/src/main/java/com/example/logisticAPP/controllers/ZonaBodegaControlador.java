package com.example.logisticAPP.controllers;


import com.example.logisticAPP.models.DTO.CommodityDTO;
import com.example.logisticAPP.models.StoreZone;
import com.example.logisticAPP.services.StoreZoneServices;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.ExampleObject;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("logisticApp/v1/zonaBodega")
@Tag(name="Servicios zona de la bodega", description = "\nServicios asociados a la tabla zonas_bodega de la bd")
public class ZonaBodegaControlador {

    @Autowired
    StoreZoneServices zonaBodegaServicio;

    @PostMapping
    @Operation(
            summary = "Registra una zona en la base de datos",
            description = "Se envia una Zona bodega que responde al modelo Zona bodega y se retorna un DTO con los datos de la zona bodega"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Zona bodega duardado con exito en la BD",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CommodityDTO.class),
                                    //CORREGIR ESTO
                                    examples = @ExampleObject(value = "{\"idZona\":\"1\",\"nombreZona\":\"Zona A\",\"volumenMaximo\":\"300\"," +
                                            "\"pesoMaximo\":\"100\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error al registrar la zona",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    //Se crea un método para llamar a cada uno de los servicios disponibles
    public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody StoreZone datosZonaBodega) {
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.zonaBodegaServicio.registrar(datosZonaBodega));

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

            return ResponseEntity.status(HttpStatus.OK).body(this.zonaBodegaServicio.buscarMercancias());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }

    @GetMapping("/zonas")
    public ResponseEntity<?> obtenerZonas() {
        try {
            // Llamar al servicio para obtener todas las zonas
            return ResponseEntity.status(HttpStatus.OK).body(zonaBodegaServicio.buscarMercancias());
        } catch (Exception e) {
            // Manejo de errores en caso de falla
            HashMap<String, Object> respuestaError = new HashMap<>();
            respuestaError.put("mensaje", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(respuestaError);
        }
    }

    @PostMapping("/ingresarProducto/{idZona}")
    public ResponseEntity<?> ingresarProductoEnZona(@PathVariable Integer idZona,
                                                    @RequestParam Double pesoProducto,
                                                    @RequestParam Double volumenProducto) {
        try {
            StoreZone zonaActualizada = zonaBodegaServicio.ingresarProductoEnZona(idZona, pesoProducto, volumenProducto);
            HashMap<String, Object> respuesta = new HashMap<>();
            respuesta.put("idZona", zonaActualizada.getIdZona());
            respuesta.put("pesoOcupado", zonaActualizada.getPesoOcupado());
            respuesta.put("volumenOcupado", zonaActualizada.getVolumenOcupado());
            respuesta.put("pesoRestante", zonaActualizada.getPesoRestante());
            respuesta.put("volumenRestante", zonaActualizada.getVolumenRestante());
            return ResponseEntity.status(HttpStatus.OK).body(respuesta);
        } catch (Exception error) {
            HashMap<String, Object> respuestaError = new HashMap<>();
            respuestaError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestaError);
        }
    }
}

