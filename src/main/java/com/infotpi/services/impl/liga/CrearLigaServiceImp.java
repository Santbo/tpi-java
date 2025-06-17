package com.infotpi.services.impl.liga;


import com.infotpi.entidades.Liga;
import com.infotpi.services.interfaces.CrearLigaService;

public class CrearLigaServiceImp implements CrearLigaService{
    

    @Override
    public Liga crear(String nombre){

        return new Liga(nombre);
        
    }
}
