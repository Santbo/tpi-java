package com.infotpi.services.impl.partido;

import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Partido;
import com.infotpi.entidades.Resultado;
import com.infotpi.services.interfaces.CrearPartidoService;

public class CrearPartidoServiceImp implements CrearPartidoService{
    
    @Override
    public Partido crear(Equipo equipoLocal, 
                        Equipo equipoVisitante, 
                        Resultado resultado, 
                        Map<Jugador, Integer> golesPorJugador){
        
        return new Partido(equipoLocal, equipoVisitante, resultado, golesPorJugador);
    }
}
