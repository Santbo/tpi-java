package com.infotpi.services.impl.equipo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.services.interfaces.ListarEquipoService;
import com.infotpi.services.interfaces.RankingEquiposXGolService;

public class RankingEquiposXGolServiceImp implements RankingEquiposXGolService{
    
    private ListarEquipoService listarEquipos = new ListarEquipoServiceImp();

    public List<Equipo> obtenerRankingEquipo(RepositorioDeDatos repositorioDeDatos){

        List<Equipo> rankingEquipos = new ArrayList<>(listarEquipos.listar(repositorioDeDatos));

        Collections.sort(rankingEquipos, Comparator.comparing(Equipo::getGolesDelEquipo));

        return rankingEquipos;

        


    }
}
