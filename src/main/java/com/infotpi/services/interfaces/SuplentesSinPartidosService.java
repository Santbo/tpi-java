package com.infotpi.services.interfaces;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Jugador;


public interface SuplentesSinPartidosService {
    

    List<Jugador> suplenteSinPartidos(Map<Jugador, String> jugadores);
}
