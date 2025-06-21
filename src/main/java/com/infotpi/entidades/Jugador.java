package com.infotpi.entidades;

public abstract class Jugador {
    
    protected String nombre;
    protected int edad;
    protected int partidosJugados;
    protected int golesHistoricos;
    protected Equipo equipo;

    public Jugador (String nombre, int edad){

        this.nombre = nombre;
        this.edad = edad;
        this.golesHistoricos = 0;
    }

    public abstract void mostrarEstadistica();

    public String getNombre(){

        return this.nombre;
    }

    public Equipo getEquipo(){

        return this.equipo;
    }

    public void agregarAEquipo(Equipo equipo){

        this.equipo = equipo;
    }

    public void setPartidosJugados(int partidosJugados){
        
        this.partidosJugados += partidosJugados;
    }

    public int getPartidosJugados(){

        return this.partidosJugados;
    }

    public void setGolesHistoricos(int golesHistoricos){
        
        this.golesHistoricos += golesHistoricos;
    }

    public int getGolesHistoricos(){

        return this.golesHistoricos;
    }

    public int getEdad(){

        return this.edad;
    }

}
