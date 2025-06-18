package com.infotpi.entidades;

public class Suplente extends Jugador {
    
    private int partidosJugados = 0;
    private Equipo equipo;

    public Suplente (String nombre, int edad){

        super(nombre, edad);
    }

    public String getNombre(){

        return this.nombre;
    }

    public int getCantidadGoles(){

        return this.cantidadGoles;
    }

    public int getPartidosJugados(){

        return this.partidosJugados;
    }

    public void setCantidadGoles(int golesAnotados){

        this.cantidadGoles += golesAnotados;
    }

    public void setPartidosJugados(int partidosJugados){

        this.partidosJugados += partidosJugados;
    }

    public void agregarAEquipo(Equipo equipo){

        this.equipo = equipo;
    }

    public void mostrarEstadistica(){
        
    }

    public Equipo getEquipo(){

        return this.equipo;
    }

}
