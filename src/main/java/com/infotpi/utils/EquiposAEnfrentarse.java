package com.infotpi.utils;

import java.util.List;

import com.infotpi.entidades.Equipo;


public class EquiposAEnfrentarse {
    
    public static Equipo equiposAenfrentarse (List<Equipo> equiposAenfrentarse){

        int opcion;
        int indice = 0;
        for (Equipo equipo : equiposAenfrentarse){
                        
            System.out.printf("[%d] %s\n", indice, equipo.getNombre());
            indice++;
                        
        }

        opcion = ControlarEntradaDatos.controlarEntradaDeDatos(equiposAenfrentarse.size());

        Equipo equipoSeleccionado = equiposAenfrentarse.get(opcion);

        equiposAenfrentarse.remove(opcion);

        return equipoSeleccionado; 

    }
}
