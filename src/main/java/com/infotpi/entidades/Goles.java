package com.infotpi.entidades;

public class Goles {
    
    private Equipo equipo;
    private Jugador jugador;

    public Goles(Equipo equipo , Jugador jugador){

        this.equipo = equipo;
        this.jugador = jugador;
    }
    public Jugador getJugador() {
        return jugador;
    }

    public Equipo getEquipo() {
        return equipo;
    }

}
