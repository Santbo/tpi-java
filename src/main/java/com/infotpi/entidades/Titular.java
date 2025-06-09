package com.infotpi.entidades;

public class Titular extends Jugador {
    
    private int minutosJugados = 0;

    public Titular(String nombre, int edad, int cantidadGoles) {

        super(nombre, edad, cantidadGoles);


    }

    public String getNombre(){

        return this.nombre;
    }

    public int getMinutosJugados(){

        return this.minutosJugados;
    }

    public int getCantidadGoles(){

        return this.cantidadGoles;
    }

    public void setCantidadGoles(int golesAnotados){

        this.cantidadGoles += golesAnotados;
    }

    public void setMinutosJugados(int minutosJugados){

        this.minutosJugados += minutosJugados;
    }

    public void mostrarEstadistica(){
        
    }


}
