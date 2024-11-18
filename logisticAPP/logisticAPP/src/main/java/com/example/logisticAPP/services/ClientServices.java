package com.example.logisticAPP.services;

import com.example.logisticAPP.models.Client;

import com.example.logisticAPP.models.Commodity;
import com.example.logisticAPP.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {

    @Autowired
    IClientRepository consultaBD;

    public Client registrar (Client datosCliente)throws Exception{
    try {
        return this.consultaBD.save(datosCliente);
    } catch (Exception error){
        throw new Exception(error.getMessage());
    }
    }

    public List<Client> buscarMercancias()throws Exception{
        try {
            return this.consultaBD.findAll();
        } catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
}
