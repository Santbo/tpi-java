package com.infotpi.utils;

import java.util.Map;

import com.infotpi.entidades.Jugador;

public class ListarJugadores {
    
    public static void ListarTodosLosJugadores(Map<Jugador, String> jugadores){

        jugadores.forEach((jugador, tipo) -> System.out.println(jugador.getNombre() + " - " + tipo));
    }
}
