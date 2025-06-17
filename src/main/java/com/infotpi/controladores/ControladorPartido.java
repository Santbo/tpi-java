package com.infotpi.controladores;
import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Liga;
import com.infotpi.services.impl.equipo.ListarEquipoServiceImp;
import com.infotpi.services.impl.liga.ListarLigaServiceImp;
import com.infotpi.services.interfaces.ListarEquipoService;
import com.infotpi.services.interfaces.ListarLigasService;
import com.infotpi.utils.ControlarEntradaDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorPartido extends Controlador{
    
    private int opcion;
    private ListarEquipoService listarEquipo = new ListarEquipoServiceImp();
    private ListarLigasService listarLiga = new ListarLigaServiceImp();

    public void iniciar(RepositorioDeDatos repositorioDeDatos){

        do{

            Menu.menuPartidos();
            this.opcion = ControlarOpcionesMenu.opcionesMenuEquipo();
            List<Equipo> equipos = this.listarEquipo.listar(repositorioDeDatos);
            List<Liga> ligas = this.listarLiga.listar(repositorioDeDatos);
            int indice = 0;
            int opcionLiga = 0;

            switch(this.opcion){


                case 1:

                    System.out.println("Elije la liga la cual jugar: ");

                    for (Liga liga : listarLiga.listar(repositorioDeDatos)){

                        System.out.printf("[%d] %s\n", indice, liga.getNombre());
                        indice++; 
                    }

                    opcionLiga = ControlarEntradaDatos.controlarEntradaDeDatos(listarLiga.listar(repositorioDeDatos).size());

                    System.out.println("Elije los equipos que se enfrentaran: ");

                    System.out.println("Equipo Local.");

                    indice = 0;

                    List<Equipo> equiposAenfrentarse = listarEquipo.listar(repositorioDeDatos);
                    for (Equipo equipo : equiposAenfrentarse){
                        
                        System.out.printf("[%d] %s\n", indice, equipo.getNombre());
                        indice++;
                        
                    }

                    int opcionEquipoLocal = ControlarEntradaDatos.controlarEntradaDeDatos(equiposAenfrentarse.size());
                    equiposAenfrentarse.remove(opcionEquipoLocal);

                    System.out.println("Equipo Visitante");

                    for (Equipo equipo : equiposAenfrentarse){
                        
                        System.out.printf("[%d] %s\n", indice, equipo.getNombre());
                        indice++;
                        
                    }

                    int opcionEquipoVisitante = ControlarEntradaDatos.controlarEntradaDeDatos(equiposAenfrentarse.size());

                    
            }
        } while (this.opcion != 0);

    }
}
