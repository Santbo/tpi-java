package com.infotpi.controladores;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;
import com.infotpi.services.impl.equipo.ListarEquipoServiceImp;
import com.infotpi.services.impl.liga.ListarLigaServiceImp;
import com.infotpi.services.impl.partido.PartidoEnVivoServiceImp;
import com.infotpi.services.impl.partido.SeleccionarJugadoresPartidoServiceImp;
import com.infotpi.services.interfaces.ListarEquipoService;
import com.infotpi.services.interfaces.ListarLigasService;
import com.infotpi.services.interfaces.PartidoEnVivoService;
import com.infotpi.services.interfaces.SeleccionarJugadoresPartidoService;
import com.infotpi.utils.ControlarEntradaDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.EquiposAEnfrentarse;
import com.infotpi.utils.Menu;

public class ControladorPartido extends Controlador{
    
    private int opcion;
    private ListarEquipoService listarEquipo = new ListarEquipoServiceImp();
    private ListarLigasService listarLiga = new ListarLigaServiceImp();
    private SeleccionarJugadoresPartidoService seleccionarJugadores = new SeleccionarJugadoresPartidoServiceImp();
    private PartidoEnVivoService partidoEnVivo = new PartidoEnVivoServiceImp();

    public void iniciar(RepositorioDeDatos repositorioDeDatos){


        do{

            if (repositorioDeDatos.getLiga().isEmpty() ||
                repositorioDeDatos.getEquipoVacio() ||
                repositorioDeDatos.getJugadoresVacio()){

                System.out.println("Primero debe crear una Liga, Equipo y Jugadores");
                break;
            } 

            Menu.menuPartidos();
            this.opcion = ControlarOpcionesMenu.opcionesMenuEquipo();
            List<Liga> ligas = this.listarLiga.listar(repositorioDeDatos);
            int indice = 0;
            int opcionEnfrentamiento= 0;
            Equipo equipoLocal;
            Equipo equipoVisitante;
            Liga ligaAJugar;
            Map<Jugador, Equipo> jugadoresEnfrentados = new HashMap<>();

            switch(this.opcion){


                case 1:

                    if (repositorioDeDatos.getEquipo().size() < 2) {

                        System.out.println("No puede iniciar un partido con un solo equipo. Cree otro e intente nuevamente.");
                        continue;
                    }

                    System.out.println("Elije la liga la cual jugar: ");

                    for (Liga liga : listarLiga.listar(repositorioDeDatos)){

                        System.out.printf("[%d] %s\n", indice, liga.getNombre());
                        indice++; 
                    }

                    opcionEnfrentamiento = ControlarEntradaDatos.controlarEntradaDeDatos(listarLiga.listar(repositorioDeDatos).size());

                    ligaAJugar = ligas.get(opcionEnfrentamiento);

                    System.out.println("Elije los equipos que se enfrentaran: ");

                    System.out.println("Equipo Local:");

                    indice = 0;

                    List<Equipo> equiposAenfrentarse = this.listarEquipo.listar(repositorioDeDatos);
            
                    equipoLocal = EquiposAEnfrentarse.equiposAenfrentarse(equiposAenfrentarse);

                    System.out.println("Equipo Visiante:");

                    equipoVisitante = EquiposAEnfrentarse.equiposAenfrentarse(equiposAenfrentarse);

                    if (equipoLocal.getJugadores().isEmpty() || 
                        equipoVisitante.getJugadores().isEmpty()){

                        System.out.println("Para jugar un partido debe tener jugadores agregados al equipo seleccionado.");
                        continue;
                    }

                    System.out.println("Selecciona los jugadores que jugarán: ");

                    jugadoresEnfrentados = seleccionarJugadores.seleccionarJugadoresAJugar(equipoLocal, equipoVisitante);

                    partidoEnVivo.iniciar(jugadoresEnfrentados, equipoLocal, equipoVisitante, ligaAJugar);
                    break;

                case 2:

                    List<Equipo> equipos = listarEquipo.listar(repositorioDeDatos);
                    indice = 1;
                    double acumularGoles = 0;

                    for (Equipo equipo : equipos){

                        acumularGoles += equipo.getGolesDelEquipo();
                        indice++;
                    }

                    System.out.printf("El promedio de goles de todos los equipos es de: .2%f goles \n", acumularGoles / indice);
                    break;
            }
        } while (this.opcion != 0);

    }
}
