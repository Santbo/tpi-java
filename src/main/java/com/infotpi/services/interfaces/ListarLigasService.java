package com.infotpi.services.interfaces;

import com.infotpi.data.RepositorioDeDatos;
import java.util.List;
import com.infotpi.entidades.Liga;

public interface ListarLigasService {
    

    List<Liga> listar(RepositorioDeDatos repositorioDeDatos);
}
