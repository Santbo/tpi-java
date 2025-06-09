package com.infotpi.entidades;

import java.util.List;

public class Equipo {
    
    private String nombre;
    private List<Jugador> jugadores;

    public Equipo (String nombre, List<Jugador> jugadores){

        this.nombre = nombre;
        this.jugadores = jugadores;
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
