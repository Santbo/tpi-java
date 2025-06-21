package com.infotpi.utils;

import java.util.List;

import com.infotpi.entidades.Equipo;

public class EquiposParaSeleccionar {
    
    public static int listar(List<Equipo> equipos){


        int indice = 0;
        for (Equipo equipo : equipos){

            System.out.printf("[%d] %s\n", indice, equipo.getNombre());
            indice++; 
        }

        int opcion = ControlarEntradaDatos.controlarEntradaDeDatos(equipos.size());

        return opcion;
    }
}
