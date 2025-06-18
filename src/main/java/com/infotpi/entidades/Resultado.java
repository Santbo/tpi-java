package com.infotpi.entidades;

public class Resultado {
    
    private int golLocal;
    private int golVisitante;
    private boolean esEmpate;

    public boolean getEsEmpate() {
        return esEmpate;
    }

    public int getGolLocal() {
        return golLocal;
    }

    public int getGolVisitante() {
        return golVisitante;
    }

    public void setGolLocal(int gol){

        this.golLocal += gol;
    }

    public void setGolVisitante(int gol){

        this.golVisitante += gol;
    }

    public void setEsEmpate(){

        if (this.golLocal == this.golVisitante){

            this.esEmpate = true;
        } else {

            System.out.println("Error. No se puede empatar ya que los resultados son distintos.");
        }
    }
}
