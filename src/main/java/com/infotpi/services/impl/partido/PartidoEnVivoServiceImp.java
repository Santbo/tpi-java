package com.infotpi.services.impl.partido;

import java.util.HashMap;
import java.util.Map;

import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;
import com.infotpi.entidades.Resultado;
import com.infotpi.services.interfaces.CrearPartidoService;
import com.infotpi.services.interfaces.GolAnotadoService;
import com.infotpi.services.interfaces.PartidoEnVivoService;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class PartidoEnVivoServiceImp implements PartidoEnVivoService{

    private int opcion;
    private GolAnotadoService anotarGol = new GolAnotadoServiceImp();
    private CrearPartidoService crearPartido = new CrearPartidoServiceImp();
    
    public void iniciar(Map<Jugador, Equipo> jugadoresEnfrentados, Equipo equipoLocal, Equipo equipoVisitante, Liga liga){

        int golLocal = 0;
        int golVisitante = 0;
        Resultado resultadoPartido = new Resultado();
        Map<Jugador, Integer> golesPorJugador = new HashMap<>();
        boolean partidoIniciado = false;
        
        
        do {
            Menu.partidoEnVivo();
            this.opcion = ControlarOpcionesMenu.opcionMenuPartidoEnVivo();
            
            switch (opcion) {
                case 1:
                    partidoIniciado = true;
                    Map<Jugador, Integer>golAnotado = anotarGol.meterGol(jugadoresEnfrentados, equipoLocal);
                    Map.Entry<Jugador, Integer> entrada = golAnotado.entrySet().iterator().next();
                    Jugador jugador = entrada.getKey();
    
                    golesPorJugador.merge(jugador, 1, Integer::sum);
    
                    if (jugador.getEquipo().equals(equipoLocal)){
    
                        golLocal += 1;
    
                    } else {
    
                        golVisitante += 1;
                    }
                    
                    break;
            
                case 2:
    
                    resultadoPartido.setGolLocal(0);
                    resultadoPartido.setGolVisitante(0);
                    resultadoPartido.setEsEmpate();

                    liga.setPartidos(crearPartido.crear(equipoLocal, equipoVisitante, resultadoPartido, golesPorJugador));
                    break;
    
                case 3:
                    
                    if (partidoIniciado){

                        resultadoPartido.setGolLocal(golLocal);
                        resultadoPartido.setGolVisitante(golVisitante);
        
                        if (golLocal == golVisitante) {
                            resultadoPartido.setEsEmpate();
                        }

                        liga.setPartidos(crearPartido.crear(equipoLocal, equipoVisitante, resultadoPartido, golesPorJugador));
                        
                    } else{

                        System.out.println("Error. Debe iniciar un partido antes de terminarlo.");
                    }

                    this.opcion = 0;
                    break;



                    
            }
            
        } while (this.opcion != 0);
        
    }

}
