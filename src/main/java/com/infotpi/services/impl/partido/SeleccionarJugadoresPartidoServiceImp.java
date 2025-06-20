package com.infotpi.services.impl.partido;

import java.util.HashMap;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.SeleccionarJugadoresPartidoService;
import com.infotpi.utils.SeleccionJugadoresPartido;

public class SeleccionarJugadoresPartidoServiceImp implements SeleccionarJugadoresPartidoService{
    
    @Override
    public Map<Jugador, Equipo> seleccionarJugadoresAJugar (Equipo equipoLocal, Equipo equipoVisitante){

        Map<Jugador, Equipo> jugadoresSeleccionados = new HashMap<>();

        System.out.println("Elija los jugadores del Equipo Local: " + equipoLocal.getNombre());
        
        jugadoresSeleccionados = SeleccionJugadoresPartido.seleccionarJugador(equipoLocal.getJugadores(), equipoLocal);


        System.out.println("Elija los jugadores del Equipo Visitante: " + equipoVisitante.getNombre());
        
        jugadoresSeleccionados.putAll(SeleccionJugadoresPartido.seleccionarJugador(equipoVisitante.getJugadores(), equipoVisitante));

        jugadoresSeleccionados.forEach((jugador, equipo)-> jugador.setPartidosJugados(1));
        
        return jugadoresSeleccionados;
    }

}
