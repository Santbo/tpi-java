package com.infotpi.services.interfaces;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public interface TransferirJugadorService {
    
    void transferir(Equipo desde, Equipo hacia, Jugador jugador);

}
