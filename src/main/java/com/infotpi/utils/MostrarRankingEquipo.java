package com.infotpi.utils;

import java.util.List;

import com.infotpi.entidades.Equipo;

public class MostrarRankingEquipo {
    
    public static void mostrar(List<Equipo> rankingEquipos){

        int indice = 1;

        for (Equipo equipo: rankingEquipos){

        System.out.printf("%d° %s con %d goles\n", indice, equipo.getNombre(), equipo.getGolesDelEquipo());

        indice++;

        }

    }
}
