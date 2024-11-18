package com.example.logisticAPP.controllers;

import com.example.logisticAPP.models.Client;
import com.example.logisticAPP.models.DTO.CommodityDTO;
import com.example.logisticAPP.services.ClientServices;
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
@RequestMapping("logisticApp/v1/clientes") //endpoint orientado al recurso
@Tag(name="Servicios cliente en bodega", description = "\nServicios asociados a la tabla cliente de la bd")
public class ClienteControlador {

    @Autowired
    ClientServices clienteServicio;

    @PostMapping
    @Operation(
            summary = "Registra un cliente en la base de datos",
            description = "Se envia un Cliente que responde al modelo Cliente y se retorna un DTO con los datos" +
                    " del cliente"
    )
    @ApiResponses(
            value = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Cliente guardado con exito en la bd",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = CommodityDTO.class),
                                    examples = @ExampleObject(value = "{\"nombreCliente\":\"Caren\",\"departamentoCliente\":\"Antioquia\",\"municipioCliente\":\"Medellin\"," +
                                            "\"direccionCliente\":\"Cra 104a\", \"correoCliente\":\"caren@gmail.com\", \"telefonoCliente\":\"12345\"}")
                            )
                    ),
                    @ApiResponse(
                            responseCode = "400",
                            description = "Error al registrar el cliente",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = String.class)
                            )
                    )
            }
    )
    public ResponseEntity<?> llamandoAlServicioParaGuardar(@RequestBody Client datosCliente ){
        try {
            return ResponseEntity.status(HttpStatus.CREATED).body(this.clienteServicio.registrar(datosCliente));
        } catch (Exception error){
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }

    @GetMapping
    public ResponseEntity<?> llamandoAlServicioParaBuscarTodas(){
        try {

            return ResponseEntity.status(HttpStatus.OK).body(this.clienteServicio.buscarMercancias());

        } catch (Exception error) {
            HashMap<String, Object> respuestError = new HashMap<>();
            respuestError.put("mensaje", error.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(respuestError);
        }
    }
}
