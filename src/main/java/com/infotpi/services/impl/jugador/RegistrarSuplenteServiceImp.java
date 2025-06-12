package com.infotpi.services.impl.jugador;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Suplente;
import com.infotpi.services.interfaces.RegistrarJugadorService;

public class RegistrarSuplenteServiceImp implements RegistrarJugadorService{
    
    @Override
    public Jugador registrar(String nombre, int edad){

        return new Suplente(nombre, edad);
    }

}
