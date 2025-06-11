package com.infotpi.services.impl.jugador;

import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Titular;
import com.infotpi.services.interfaces.RegistrarJugadorService;

public class RegistrarTitularServiceImp implements RegistrarJugadorService{
    
    @Override
    public Jugador registrar(String nombre, int edad, int cantidadGoles){

        return new Titular(nombre, edad, cantidadGoles);
    }

}
