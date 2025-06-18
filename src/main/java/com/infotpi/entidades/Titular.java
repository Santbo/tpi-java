package com.infotpi.entidades;

public class Titular extends Jugador {
    
    private int partidosJugados = 0;

    public Titular(String nombre, int edad) {

        super(nombre, edad);


    }

    public String getNombre(){

        return this.nombre;
    }

    public int getPartidosJugados(){

        return this.partidosJugados;
    }

    public int getCantidadGoles(){

        return this.cantidadGoles;
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
