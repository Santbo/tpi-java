package com.infotpi.entidades;

public abstract class Jugador {
    
    protected String nombre;
    protected int edad;
    protected int cantidadGoles;

    public Jugador (String nombre, int edad, int cantidadGoles){

        this.nombre = nombre;
        this.edad = edad;
        this.cantidadGoles = cantidadGoles;
    }

    public abstract void mostrarEstadistica();
}
