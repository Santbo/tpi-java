package com.infotpi.utils;

import com.infotpi.entidades.Jugador;

public class TitularConMasPartidos {
    

    public static void mostrar(Jugador jugador){

        if (jugador != null && jugador.getPartidosJugados() > 0){

            System.out.printf("El jugador Titular con mayores partidos jugados es %s con %d partidos jugados\n", 
            jugador.getNombre(), jugador.getPartidosJugados());
        } else {

            System.out.println("No hay jugadores con partidos jugados.");
        }
    }
}
