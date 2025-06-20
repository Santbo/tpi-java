package com.infotpi.services.interfaces;

import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Jugador;

public interface ExportarJugadoresEquipoService {
    
    void exportarJugadoresEquipoCSV(List<Jugador> jugadores, RepositorioDeDatos repositorioDeDatos);
}
