package com.infotpi.services.interfaces;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Goles;
import com.infotpi.entidades.Jugador;

public interface MeterGolService {
    

    Goles meterGol(Equipo equipo, Jugador jugador);
}
