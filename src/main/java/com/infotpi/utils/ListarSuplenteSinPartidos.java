package com.infotpi.utils;

import java.util.List;

import com.infotpi.entidades.Jugador;

public class ListarSuplenteSinPartidos {
    

    public static void listar(List<Jugador> suplentes){

        
        for (Jugador suplente : suplentes){

            System.out.printf("Jugador: %s - Equipo: %s\n", suplente.getNombre(), 
            (suplente.getEquipo() == null)? "No posee" : suplente.getEquipo().getNombre());
        }  
    }
}
