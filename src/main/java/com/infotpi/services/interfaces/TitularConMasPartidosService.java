package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.entidades.Jugador;

public interface TitularConMasPartidosService {
    
    Jugador obtener(Map<Jugador, String> jugadores);
}





