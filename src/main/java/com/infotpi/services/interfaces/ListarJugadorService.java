package com.infotpi.services.interfaces;

import java.util.Map;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Jugador;

public interface ListarJugadorService {
    
    Map<Jugador, String> listar(RepositorioDeDatos repositorioDeDatos);
}
