package com.infotpi.services.impl.jugador;

import java.util.HashMap;
import java.util.Map;


import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.EficienciaDeJugadoresService;

public class EficienciaDeJugadoresServiceImp implements EficienciaDeJugadoresService{
    
    @Override
    public Map<Jugador, Double> mostrar(Map<Jugador, String> jugadores){


        Map<Jugador, Double> eficienciaJugadores = new HashMap<>();

        jugadores.forEach((jugador, tipo)->{

            if (jugador.getPartidosJugados() != 0){

                eficienciaJugadores.put(jugador, Double.valueOf(jugador.getGolesHistoricos() / jugador.getPartidosJugados()));

            }

        });

        return eficienciaJugadores;

    }

    @Override
    public Jugador jugadorMasEficiente(Map<Jugador, Integer> golesPorJugador){

        Jugador maximoGoleadorLiga = golesPorJugador.entrySet()
                                                    .stream()
                                                    .max(Map.Entry.comparingByValue())
                                                    .get()
                                                    .getKey();

        return maximoGoleadorLiga;
    }
}
