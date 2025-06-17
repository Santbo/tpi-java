package com.infotpi.services.impl.equipo;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.TransferirJugadorService;

public class TransferirJugadorServiceImp implements TransferirJugadorService {
    
    public void transferir(Equipo desde, Equipo hacia, Jugador jugador){

        desde.transferirJugador(jugador);
        hacia.setJugadores(jugador);
    }
}
