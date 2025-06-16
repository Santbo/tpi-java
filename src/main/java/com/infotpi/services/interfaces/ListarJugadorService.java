package com.infotpi.services.interfaces;

import java.util.List;
import java.util.Map;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Jugador;

public interface ListarJugadorService {
    
    Map<Jugador, String> listar(RepositorioDeDatos repositorioDeDatos);

    List<Jugador> listarSinEquipo(RepositorioDeDatos repositorioDeDatos);
    List<Jugador> listarConEquipo(RepositorioDeDatos repositorioDeDatos);
}
