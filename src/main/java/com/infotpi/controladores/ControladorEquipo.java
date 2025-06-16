package com.infotpi.controladores;

import java.util.List;

import com.infotpi.services.interfaces.CrearEquipoService;
import com.infotpi.services.interfaces.IncorporarJugadorService;
import com.infotpi.services.interfaces.ListarEquipoService;
import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.config.Configuracion;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.impl.equipo.CrearEquipoServiceImp;
import com.infotpi.services.impl.equipo.IncorporarJugadorServiceImp;
import com.infotpi.services.impl.equipo.ListarEquipoServiceImp;
import com.infotpi.services.impl.jugador.ListarJugadorServiceImp;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;
import static com.infotpi.utils.UtilsScanner.SCANNER;

public class ControladorEquipo extends Controlador{

    private int opcion;
    private CrearEquipoService crearEquipo = new CrearEquipoServiceImp();
    private IncorporarJugadorService incorporarJugador = new IncorporarJugadorServiceImp();
    private ListarEquipoService listarEquipo = new ListarEquipoServiceImp();
    private ListarJugadorService listarJugadores = new ListarJugadorServiceImp();
    
    public  void iniciar(RepositorioDeDatos repositorioDeDatos){

        do {

            Menu.menuEquipos();
            this.opcion = ControlarOpcionesMenu.opcionesMenuEquipo();
    
            switch (this.opcion) 
            {

                case 1: 

                    if (repositorioDeDatos.getEquipo() != null && 
                    repositorioDeDatos.getEquipo().size() >= Configuracion.MAXIMO_EQUIPOS) {

                        System.out.println("Error. Se alcanzó la capacidad máxima de equipos que se pueden crear.");
                        break;
                    }
                    System.out.print("Ingrese el nombre del Equipo: ");
                    String nombre = SCANNER.nextLine();

                    repositorioDeDatos.guardarEquipos(crearEquipo.crear(nombre));
                        
                    break;
                
                case 2: 
                    
                    
                    if (repositorioDeDatos.getEquipoVacio() || repositorioDeDatos.getJugadoresVacio()){

                        System.out.println("Primero debe crear Jugadores y Equipos");
                        continue;
                    } 
                    List<Equipo> equipos = listarEquipo.listar(repositorioDeDatos);
                    System.out.println("Elija el equipo al que quiere ingresar el jugador: ");
                    
                    int indice = 0;
                    for (Equipo equipo : equipos){

                        
                        System.out.printf("[%d] %s\n", indice, equipo.getNombre());
                        indice++; 
                    }

                    int opcionEquipo = 0;

                    while(Boolean.TRUE){

                        System.out.println("Elije un equipo: ");
                        opcionEquipo = Integer.parseInt(SCANNER.nextLine());
                        
                        if (opcionEquipo < 0 || opcionEquipo >= equipos.size()) {
    
                            System.out.println("Error al elegir un equipo. Intente nuevamente.");
                        }
                        else {
                            break;
                        }

                    }

                    if (equipos.get(opcionEquipo).getJugadores() != null &&
                    equipos.get(opcionEquipo).getJugadores().size() >= Configuracion.MAXIMO_JUGADORES_X_EQUIPO){

                        System.out.println("Error. Se alncanzó la capacidad máxima de jugadores en el equipo.");
                        break;
                    }

                    if(listarJugadores.listarSinEquipo(repositorioDeDatos).isEmpty()){

                        System.out.println("No hay jugadores sin equipos.");
                        continue;
                    }

                    System.out.println("Jugadores sin equipos: ");
                    

                    indice = 0;
                    for (Jugador jugador : listarJugadores.listarSinEquipo(repositorioDeDatos)){
                         System.out.printf("[%d] %s\n", indice, jugador.getNombre());
                        indice++; 
                        
                    }

                    int opcionJugador = 0;

                    while(Boolean.TRUE){

                        

                        System.out.println("Elije un jugador: ");
                        opcionJugador = Integer.parseInt(SCANNER.nextLine());
                        
                        if (opcionJugador < 0 || opcionJugador >= listarJugadores.listarSinEquipo(repositorioDeDatos).size()) {
    
                            System.out.println("Error al elegir un equipo. Intente nuevamente.");
                        }
                        else {
                            break;
                        }

                    }


                    incorporarJugador.incorporar(equipos.get(opcionEquipo), listarJugadores.listarSinEquipo(repositorioDeDatos).get(opcionJugador));


            }
        

        } while(this.opcion != 0);

    }
}

