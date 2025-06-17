package com.infotpi.entidades;

import java.util.ArrayList;
import java.util.List;

public class Liga {
    
    private String nombre;
    private List<Partido> partidos = new ArrayList<>();

    public Liga(String nombre){
        
        this.nombre = nombre;
    }

    public void setPartidos(Partido partido){

        this.partidos.add(partido);
    }

    public String getNombre(){

        return this.nombre;
    }

    public List<Partido> getPartidos(){

        return this.partidos;
    }
}   
