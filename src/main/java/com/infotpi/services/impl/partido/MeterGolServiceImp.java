package com.infotpi.services.impl.partido;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Goles;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.MeterGolService;

public class MeterGolServiceImp implements MeterGolService{

    public Goles meterGol(Equipo equipo, Jugador jugador){

        return new Goles(equipo, jugador);
    }
    
    
}
