package com.infotpi.data;

import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Partido;

import com.infotpi.config.Config;
import java.util.List;

public class RepositorioDeDatos {
    

    private List<Jugador> jugadores;
    private List<Equipo> equipos;
    private List<Partido> partidos;

    public void guardarJugador(Jugador jugador){

        if (this.jugadores.size() < Config.MAXIMO_JUGADORES) {

            this.jugadores.add(jugador);
        }
        else 
        {
            System.out.println("Error. Se alcanzó la cantidad máxima de jugadores para crear");
        }
    }

    public void guardarEquipos(Equipo equipo){

        if (this.equipos.size() < Config.MAXIMO_EQUIPOS) {

            this.equipos.add(equipo);
        }
        else 
        {
            System.out.println("Error. Se alcanzó la cantidad máxima de equipos para crear");
        }
    }

    public List<Jugador> getJugadores(){

        return this.jugadores;
    }

    public List<Equipo> getEquipo(){

        return this.equipos;
    }

    public boolean getEquipoVacio(){

        return this.equipos.isEmpty();
    }

    public boolean getJugadoresVacio(){

        return this.jugadores.isEmpty();
    }
}
