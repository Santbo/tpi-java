package com.infotpi.data;

import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;
import com.infotpi.entidades.Equipo;

import com.infotpi.config.Configuracion;

import java.util.ArrayList;
import java.util.List;

public class RepositorioDeDatos {
    

    private List<Jugador> jugadores = new ArrayList<>();
    private List<Equipo> equipos = new ArrayList<>();;
    private List<Liga> liga = new ArrayList<>();

    public void guardarJugador(Jugador jugador){

        if (this.jugadores == null ||
        this.jugadores.size() < Configuracion.MAXIMO_JUGADORES) {

            this.jugadores.add(jugador);
        }
        else 
        {
            System.out.println("Error. Se alcanzó la cantidad máxima de jugadores para crear");
        }
    }

    public void guardarEquipos(Equipo equipo){

        if (this.equipos == null || 
        this.equipos.size() < Configuracion.MAXIMO_EQUIPOS) {

            this.equipos.add(equipo);
        }
        else 
        {
            System.out.println("Error. Se alcanzó la cantidad máxima de equipos para crear");
        }
    }

    public void guardarLiga(Liga liga){
        if (this.liga == null || 
        this.liga.size() < Configuracion.MAXIMO_LIGAS) {

            this.liga.add(liga);
        }
        else 
        {
            System.out.println("Error. Se alcanzó la cantidad máxima de ligas para crear");
        }
    }

    public List<Jugador> getJugadores(){

        return this.jugadores;
    }

    public List<Equipo> getEquipo(){

        return this.equipos;
    }

    public List<Liga> getLiga(){

        return this.liga;
    }

    public boolean getEquipoVacio(){

        return this.equipos.isEmpty();
    }

    public boolean getJugadoresVacio(){

        return this.jugadores.isEmpty();
    }

}
