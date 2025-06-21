package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;

public interface GolAnotadoService {
    
    Map<Jugador, Integer> meterGol(Map<Jugador, Equipo> equiposEnfrentados, Equipo equipoLocal);
}
