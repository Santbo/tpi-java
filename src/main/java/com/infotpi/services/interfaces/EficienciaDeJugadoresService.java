package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.entidades.Jugador;

public interface EficienciaDeJugadoresService {
    

    Map<Jugador, Double> mostrar(Map<Jugador, String> jugadores);

    Jugador jugadorMasEficiente(Map<Jugador, Integer> golesDeJugador);
}
