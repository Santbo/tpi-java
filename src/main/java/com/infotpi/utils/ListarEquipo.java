package com.infotpi.utils;


import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;

public class ListarEquipo {
    
    public static void mostrarEquipos(RepositorioDeDatos repositorioDeDatos) {
        
        if (repositorioDeDatos.getEquipoVacio()){

            System.out.println("No hay equipos creados.");
        } else {

            for (Equipo equipo : repositorioDeDatos.getEquipo()) {
                System.out.println(equipo.getNombre());
            }
        }
    }

}
