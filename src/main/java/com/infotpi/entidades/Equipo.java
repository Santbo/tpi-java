package com.infotpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Equipo {
    
    private String nombre;
    private List<Jugador> jugadores = new ArrayList<>();

    public Equipo (String nombre){

        this.nombre = nombre;
    }

    public String getNombre(){

        return this.nombre;
    }

    public List<Jugador> getJugadores(){

        return this.jugadores;
    }

    public void setJugadores(Jugador jugador){

        jugadores.add(jugador);
    }

    public void transferirJugador(Jugador jugador){

        int indiceJugador = jugadores.indexOf(jugador);
        jugadores.remove(indiceJugador);
    }
    




}
