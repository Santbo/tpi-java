package com.infotpi.services.impl.equipo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Suplente;
import com.infotpi.entidades.Titular;
import com.infotpi.services.interfaces.ReporteEquipoService;

public class ReporteEquipoServiceImp implements ReporteEquipoService{
    
    public void iniciar(Equipo equipo){

        int jugadores = equipo.getJugadores().size();
        List<Jugador> jugadoresSinGoles = new ArrayList<>();

        Map<Jugador, Integer> titularesPartidosJugados = new HashMap<>();
        Map<Jugador, Integer> suplentesPartidosJugados = new HashMap<>();

        for (Jugador jugador : equipo.getJugadores()){

            if (jugador.getGolesHistoricos() == 0){

                jugadoresSinGoles.add(jugador);
            }

            if (jugador instanceof Titular){

                titularesPartidosJugados.put(jugador, jugador.getPartidosJugados());
            }

            if (jugador instanceof Suplente){

                suplentesPartidosJugados.put(jugador, jugador.getPartidosJugados());
            }


        }

        double promedioGolesJugadores = equipo.getGolesDelEquipo() / jugadores;

        Jugador titularConMasPartidosJugados = (titularesPartidosJugados.isEmpty())? null : titularesPartidosJugados.entrySet().
                                                                        stream().
                                                                        max(Map.Entry.comparingByValue()).
                                                                        get().
                                                                        getKey();

        Jugador suplenteConMasPartidosJugados = (suplentesPartidosJugados.isEmpty())? null : suplentesPartidosJugados.entrySet()
                                                                        .stream()
                                                                        .max(Map.Entry.comparingByValue())
                                                                        .get().
                                                                        getKey();

        
        System.out.println("REPORTE DE EQUIPO");
        System.out.println("===============================");

        System.out.printf("PROMEDIO GOLES POR JUGADORES: %.2f\n", promedioGolesJugadores);

        System.out.printf("JUGADORES QUE NO ANOTARON GOLES: ");
        for (Jugador jugador : jugadoresSinGoles){
            System.out.println(jugador.getNombre());
        }

        if (titularConMasPartidosJugados == null){
            System.out.println("NO HAY TITULARES EN EL EQUIPO");
        } else {

            System.out.printf("TITULAR CON MAS PARTIDO JUGADOS: %s CON %d PARTIDOS JUGADOS\n", 
                                                                                            titularConMasPartidosJugados.getNombre(),
                                                                                     titularConMasPartidosJugados.getPartidosJugados());
        
        }

        if (suplenteConMasPartidosJugados == null){
            System.out.println("NO HAY SUPLENTES EN EL EQUIPO");
        } else {
            
            System.out.printf("SUPLENTE CON MAS PARTIDO JUGADOS: %s CON %d PARTIDOS JUGADOS\n", 
                                                                                            suplenteConMasPartidosJugados.getNombre(),
                                                                                            suplenteConMasPartidosJugados.getPartidosJugados());
        }
        
        try {
            Thread.sleep(3000); // 2000 milisegundos = 2 segundos
        } catch (InterruptedException e) {
            System.out.println("El hilo fue interrumpido");
        }
    }
}
