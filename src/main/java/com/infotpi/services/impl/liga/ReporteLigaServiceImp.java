package com.infotpi.services.impl.liga;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;
import com.infotpi.entidades.Partido;
import com.infotpi.services.impl.jugador.EficienciaDeJugadoresServiceImp;
import com.infotpi.services.interfaces.EficienciaDeJugadoresService;
import com.infotpi.services.interfaces.ReporteLigaService;

public class ReporteLigaServiceImp implements ReporteLigaService {

    EficienciaDeJugadoresService eficienciaDeJugadores = new EficienciaDeJugadoresServiceImp();
    
    public void iniciar (Liga liga){

        List<Partido> partidosDeLiga = new ArrayList<>(liga.getPartidos());
        List<Equipo> equiposDeLiga = new ArrayList<>();
        Map<Jugador, Integer> goles = new HashMap<>();
        int totalGoles = 0;
        Jugador jugadorMasEficiente;
        Map<Equipo, Integer> golesEquipo = new HashMap<>();
        Equipo equipoConMasGoles;

        for (Partido partidoDeLiga : partidosDeLiga){

            equiposDeLiga.add(partidoDeLiga.getEquipoLocal());
            equiposDeLiga.add(partidoDeLiga.getEquipoVisitante());
            goles.putAll(partidoDeLiga.getGoles());
        }

        for(Equipo equipo : equiposDeLiga){

            golesEquipo.put(equipo, equipo.getGolesDelEquipo());
        }

        
        equipoConMasGoles = golesEquipo.entrySet()
                                        .stream()
                                        .max(Map.Entry.comparingByValue())
                                        .get()
                                        .getKey();

        totalGoles = goles.values().stream().mapToInt(Integer::intValue).sum();

        jugadorMasEficiente = eficienciaDeJugadores.jugadorMasEficiente(goles);

        System.out.println("REPORTE DE LIGA");
        System.out.println("===============================");

        System.out.printf("TOTAL GOLES DE LIGA: %d", totalGoles);
        System.out.printf("JUGADOR MAS EFICIENTE: %s CON %d GOLES", jugadorMasEficiente.getNombre(), 
                                                                        jugadorMasEficiente.getGolesHistoricos());
        System.out.printf("EQUIPO CON MAYOR CANTIDAD DE GOLES: %s CON %d GOLES", equipoConMasGoles.getNombre(),
                                                                                        equipoConMasGoles.getGolesDelEquipo());



        
        

        

        
    }

}
