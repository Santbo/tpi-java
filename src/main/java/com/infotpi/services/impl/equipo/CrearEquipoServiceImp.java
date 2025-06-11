package com.infotpi.services.impl.equipo;

import com.infotpi.entidades.Equipo;
import com.infotpi.services.interfaces.CrearEquipoService;

public class CrearEquipoServiceImp implements CrearEquipoService{
    
    @Override
    public Equipo crear(String nombre){

        return new Equipo(nombre);
    }
}
