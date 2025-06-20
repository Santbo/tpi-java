package com.infotpi.utils;

import java.util.Map;

import com.infotpi.entidades.Jugador;

public class EficienciaDeJugadores {
    
    public static void obtener(Map<Jugador, Double> jugadores){

        if (!jugadores.isEmpty()){

            jugadores.forEach((jugador, eficiencia)-> 
            System.out.printf("Jugador: %s Eficiencia: %.2f\n", jugador.getNombre(), eficiencia));
        } else {

            System.out.println("No hay jugadores con partidos jugados.");
        }
    }
}
