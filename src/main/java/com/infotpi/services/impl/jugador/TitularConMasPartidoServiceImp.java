package com.infotpi.services.impl.jugador;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.TitularConMasPartidosService;

public class TitularConMasPartidoServiceImp implements TitularConMasPartidosService{
    
    @Override
    public Jugador obtener(Map<Jugador, String> jugadores){

        List<Jugador> titulares = new ArrayList<>();
        
        jugadores.forEach((jugador, tipo)->{

            if (tipo.equals("Titular")){

                titulares.add(jugador);

            }

        });

        Collections.sort(titulares, Comparator.comparing(Jugador::getPartidosJugados));
        

        return titulares.get(0);

    }
}
