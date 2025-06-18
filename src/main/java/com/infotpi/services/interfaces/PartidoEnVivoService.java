package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;

public interface PartidoEnVivoService {
    
    void iniciar(Map<Jugador, Equipo> jugadoresEnfrentados, Equipo equipoLocal, Equipo equipoVisitante, Liga liga);
}
