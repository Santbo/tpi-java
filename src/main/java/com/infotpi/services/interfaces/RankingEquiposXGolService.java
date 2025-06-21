package com.infotpi.services.interfaces;

import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;

public interface RankingEquiposXGolService {
    
    List<Equipo> obtenerRankingEquipo(RepositorioDeDatos repositorioDeDatos);
}
