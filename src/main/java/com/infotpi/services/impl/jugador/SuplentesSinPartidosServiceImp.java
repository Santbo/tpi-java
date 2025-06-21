package com.infotpi.services.impl.jugador;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.SuplentesSinPartidosService;

public class SuplentesSinPartidosServiceImp implements SuplentesSinPartidosService{
    
    @Override
    public List<Jugador> suplenteSinPartidos(Map<Jugador, String>jugadores){

        List<Jugador> suplentesSinPartidos = new ArrayList<>();
        
        jugadores.forEach((jugador, tipo)->{

            if (jugador.getPartidosJugados() == 0 && tipo.equals("Suplente")){

                suplentesSinPartidos.add(jugador);

            }

        });
        

        return suplentesSinPartidos;

            
        
    }

}
