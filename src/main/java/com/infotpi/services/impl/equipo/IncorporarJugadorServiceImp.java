package com.infotpi.services.impl.equipo;

import com.infotpi.services.interfaces.IncorporarJugadorService;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public class IncorporarJugadorServiceImp implements IncorporarJugadorService{
    
    public void incorporar(Equipo equipo, Jugador jugador){

        equipo.setJugadores(jugador);
        jugador.agregarAEquipo(equipo);

    }

}
