package com.infotpi.services.interfaces;

import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Goles;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Partido;
import com.infotpi.entidades.Resultado;

public interface CrearPartidoService {
    
    Partido crear(Equipo equipoLocal, Equipo equipoVisitante, Resultado resultado, Map<Jugador, List<Goles>> golesPorJugador);
}
