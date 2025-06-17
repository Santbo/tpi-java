package com.infotpi.utils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public class ListarEquipoLocalVisitante {
 
    public static Map<Jugador, Equipo> listarLocalVisitante(List<Jugador> equipoLocal, List<Jugador>  equipoVisitante){

        Map<Jugador, Equipo> jugadoresDistintosEquipos = new HashMap<>();

        for (Jugador jugador : equipoLocal){


            jugadoresDistintosEquipos.put(jugador, jugador.getEquipo());
        }

        
        for (Jugador jugador : equipoLocal){


            jugadoresDistintosEquipos.put(jugador,  jugador.getEquipo());
        }

        return jugadoresDistintosEquipos;
        
    }
}
