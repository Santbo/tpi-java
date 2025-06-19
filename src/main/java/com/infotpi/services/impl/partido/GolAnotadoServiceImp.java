package com.infotpi.services.impl.partido;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.interfaces.GolAnotadoService;
import com.infotpi.services.interfaces.MeterGolService;
import com.infotpi.utils.ControlarEntradaDatos;

public class GolAnotadoServiceImp implements GolAnotadoService{
    
    private MeterGolService meterGol = new MeterGolServiceImp();


    @Override
    public Map<Jugador, Integer> meterGol(Map<Jugador, Equipo> equiposEnfrentados, Equipo equipoLocal){

        int[] indice = new int[1];
        int opcion = 0;
        Map<Jugador, Integer> golesPorJugador = new HashMap<>();
        
        System.out.println("Selecciona quien mete el gol: ");
        

        equiposEnfrentados.forEach((jugador, equipo)-> {

            System.out.printf("[%d] %s - Pertenece a: %s\n", indice[0], jugador.getNombre(), equipo.getNombre());
            indice[0]++;

        });

        opcion = ControlarEntradaDatos.controlarEntradaDeDatos(equiposEnfrentados.size());
        List<Map.Entry<Jugador, Equipo>> seleccionarJugadorEquipo = new ArrayList<>(equiposEnfrentados.entrySet());     

        meterGol.meterGol(seleccionarJugadorEquipo.get(opcion).getValue(), seleccionarJugadorEquipo.get(opcion).getKey());

        seleccionarJugadorEquipo.get(opcion).getValue().setGolesDelEquipo(1);

        golesPorJugador.put(seleccionarJugadorEquipo.get(opcion).getKey(), 1);

        return golesPorJugador;


        
    }
}
