package com.infotpi.entidades;

public abstract class Jugador {
    
    protected String nombre;
    protected int edad;
    protected int cantidadGoles;

    public Jugador (String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;
        this.cantidadGoles = 0;
    }

    public abstract void mostrarEstadistica();
}
