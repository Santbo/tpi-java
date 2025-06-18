package com.infotpi.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.config.Configuracion;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public class SeleccionJugadoresPartido {
    
    public static Map<Jugador, Equipo> seleccionarJugador (List<Jugador> jugadores, Equipo equipo){

        int indice = 0;
        int opcion = 0;

        List<Jugador> listaJugadores = new ArrayList<>(jugadores);
        Map<Jugador, Equipo> listaConvocados = new HashMap<>();

        do {
            indice = 0;
            for(Jugador jugador : listaJugadores){
    
                System.out.printf("[%d] %s\n", indice, jugador.getNombre());
                indice++;
            }
            
            opcion = ControlarEntradaDatos.controlarEntradaDeDatos(listaJugadores.size());

            listaConvocados.put(listaJugadores.get(opcion), equipo);

            listaJugadores.remove(opcion);

            if (listaJugadores.isEmpty()){

                break;
            }
        
        } while (listaConvocados.size() < Configuracion.MAXIMO_JUGADORES_EN_CANCHA);

        return listaConvocados;
    }
}
