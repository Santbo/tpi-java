package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public interface SeleccionarJugadoresPartidoService {
 
    Map<Jugador, Equipo> seleccionarJugadoresAJugar(Equipo equipoLocal, Equipo equipoVisitante);
}
