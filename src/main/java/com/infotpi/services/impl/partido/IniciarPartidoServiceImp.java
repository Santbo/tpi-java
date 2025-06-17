package com.infotpi.services.impl.partido;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.impl.jugador.ListarJugadorServiceImp;
import com.infotpi.services.interfaces.IniciarPartidoService;
import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.utils.ControlarEntradaDatos;
import com.infotpi.utils.ListarEquipoLocalVisitante;

public class IniciarPartidoServiceImp implements IniciarPartidoService{
    

    @Override
    public void meterGol(Equipo equipoLocal, Equipo equipoVisitante){

        Map<Jugador, Equipo> jugadores = new HashMap<>();
        int indice = 0;
        int opcion = 0;
        System.out.println("Selecciona quien mete el gol: ");
        jugadores = ListarEquipoLocalVisitante.listarLocalVisitante(equipoLocal.getJugadores(), equipoVisitante.getJugadores());

        jugadores.forEach((jugador, equipo)-> {

            System.out.printf("[%d] %s - %s", indice, jugador.getNombre(), equipo.getNombre());

        });

        opcion = ControlarEntradaDatos.controlarEntradaDeDatos(jugadores.size());

        


        
    }
}
