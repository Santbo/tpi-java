package com.infotpi.entidades;

public class Suplente extends Jugador {
    
    private int partidosIngresadosDesdeBanco = 0;

    public Suplente (String nombre, int edad, int cantidadGoles){

        super(nombre, edad, cantidadGoles);
    }

    public String getNombre(){

        return this.nombre;
    }

    public int getCantidadGoles(){

        return this.cantidadGoles;
    }

    public int getPartidosIngresadosDesdeBanco(){

        return this.partidosIngresadosDesdeBanco;
    }

    public void setCantidadGoles(int golesAnotados){

        this.cantidadGoles += golesAnotados;
    }

    public void setPartidosIngresadosDesdeBanco(int partidosIngresadosDesdeBanco){

        this.partidosIngresadosDesdeBanco += partidosIngresadosDesdeBanco;
    }

    public void mostrarEstadistica(){
        
    }

}
