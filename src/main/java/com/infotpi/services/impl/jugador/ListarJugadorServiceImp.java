package com.infotpi.services.impl.jugador;

import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Titular;
import com.infotpi.data.RepositorioDeDatos;

import java.util.Map;

public class ListarJugadorServiceImp implements ListarJugadorService{
    
    private Map<Jugador, String> jugadores;
    

    @Override
    public Map<Jugador, String> listar(RepositorioDeDatos repositorioDeDatos) {

        if (repositorioDeDatos.getJugadoresVacio()){

            System.out.println("No hay jugadores cargados.");
        } else {

            for (Jugador jugador : repositorioDeDatos.getJugadores()){
                
                if (jugador instanceof Titular) {

                    jugadores.put(jugador, "Titular");
                } else {

                    jugadores.put(jugador, "Suplente");
                }
            }

        }
        
        return jugadores;
        
        
    }
    
}
