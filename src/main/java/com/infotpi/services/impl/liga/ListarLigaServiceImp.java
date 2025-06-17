package com.infotpi.services.impl.liga;

import java.util.ArrayList;
import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Liga;
import com.infotpi.services.interfaces.ListarLigasService;

public class ListarLigaServiceImp implements ListarLigasService{

    public List<Liga> listar(RepositorioDeDatos repositorioDeDatos){

        List<Liga> ligas = new ArrayList<>();

        for (Liga liga : repositorioDeDatos.getLiga()){

            ligas.add(liga);
            
        }

        return ligas;
    }
}

