package com.infotpi.entidades;
import java.util.Map;
import java.util.List;

public class Partido {
    
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Resultado resultado;
    private Map<Jugador, List<Goles>> golesPorJugador;

    public Partido(Equipo equipoLocal, 
                    Equipo equipoVisitante, 
                    Resultado resultado, 
                    Map<Jugador, List<Goles>> golesPorJugador){

        
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.resultado = resultado;
        this.golesPorJugador = golesPorJugador;
    }

    public String getEquipos(){

        return String.format("Equipo local: %s\nEquipo visitante: %s", equipoLocal.getNombre(), equipoVisitante.getNombre());
    }

    public Resultado getResultado(){

        return this.resultado;
    }

    public Map<Jugador, List<Goles>> getGoles(){

        return this.golesPorJugador;
    }

    public void reporteDeEquipos(){

    }

    public int getEquipoGanador(){

        return 1;
    }

    public int getEquipoPerdedor(){

        return 1;
    }

}
