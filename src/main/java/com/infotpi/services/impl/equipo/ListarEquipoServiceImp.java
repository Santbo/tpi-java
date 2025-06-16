package com.infotpi.services.impl.equipo;

import java.util.ArrayList;
import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.services.interfaces.ListarEquipoService;

public class ListarEquipoServiceImp implements ListarEquipoService{

    

    public List<Equipo> listar(RepositorioDeDatos repositorioDeDatos){

        List<Equipo> equipos = new ArrayList<>();

        for (Equipo equipo : repositorioDeDatos.getEquipo()){

            equipos.add(equipo);
            
        }

        return equipos;
    }
    
}
