package com.infotpi.services.interfaces;

import com.infotpi.entidades.Jugador;

public interface RegistrarJugadorService {
    
    Jugador registrar(String nombre, int edad);
}
