package com.infotpi.entidades;
import java.util.Map;

public class Partido {
    
    private Equipo equipoLocal;
    private Equipo equipoVisitante;
    private Resultado resultado;
    private Map<Jugador, Integer> golesPorJugador;

    public Partido(Equipo equipoLocal, 
                    Equipo equipoVisitante, 
                    Resultado resultado, 
                    Map<Jugador, Integer> golesPorJugador){

        
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

    public Map<Jugador, Integer> getGoles(){

        return this.golesPorJugador;
    }

    public Equipo getEquipoLocal(){

        return this.equipoLocal;
    }

    public Equipo getEquipoVisitante(){

        return this.equipoVisitante;
    }

}
