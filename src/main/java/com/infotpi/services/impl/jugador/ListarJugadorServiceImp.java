package com.infotpi.services.impl.jugador;

import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Titular;
import com.infotpi.data.RepositorioDeDatos;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListarJugadorServiceImp implements ListarJugadorService{
    
    private Map<Jugador, String> jugadores = new HashMap<>();
    

    @Override
    public Map<Jugador, String> listar(RepositorioDeDatos repositorioDeDatos) {

        if (repositorioDeDatos.getJugadoresVacio()){

            System.out.println("No hay jugadores cargados.");
            return Collections.emptyMap();
        } 

        for (Jugador jugador : repositorioDeDatos.getJugadores()){
            
            if (jugador instanceof Titular) {

                jugadores.put(jugador, "Titular");
            } else {

                jugadores.put(jugador, "Suplente");
            }
        }

        
        
        return jugadores;
        
        
    }

    public List<Jugador> listarSinEquipo(RepositorioDeDatos repositorioDeDatos){

        List<Jugador> jugadorSinEquipo = new ArrayList<>();

        for (Jugador jugador : repositorioDeDatos.getJugadores()){

            if (jugador.getEquipo() == null){

                jugadorSinEquipo.add(jugador);
            }

        }

        return jugadorSinEquipo;

    }

    public List<Jugador> listarConEquipo(RepositorioDeDatos repositorioDeDatos){

        List<Jugador> jugadorConEquipo = new ArrayList<>();

        for (Jugador jugador : repositorioDeDatos.getJugadores()){

            if (jugador.getEquipo() != null){

                jugadorConEquipo.add(jugador);
            }

        }

        return jugadorConEquipo;

    }
    
}
