package com.infotpi.services.interfaces;

import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;


public interface ListarEquipoService {

    List<Equipo> listar(RepositorioDeDatos repositorioDeDatos);
    
} 
    

