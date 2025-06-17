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
}
