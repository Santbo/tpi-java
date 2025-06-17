package com.infotpi.controladores;

import java.util.List;

import com.infotpi.services.interfaces.CrearEquipoService;
import com.infotpi.services.interfaces.IncorporarJugadorService;
import com.infotpi.services.interfaces.ListarEquipoService;
import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.services.interfaces.TransferirJugadorService;
import com.infotpi.config.Configuracion;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Equipo;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.impl.equipo.CrearEquipoServiceImp;
import com.infotpi.services.impl.equipo.IncorporarJugadorServiceImp;
import com.infotpi.services.impl.equipo.ListarEquipoServiceImp;
import com.infotpi.services.impl.equipo.TransferirJugadorServiceImp;
import com.infotpi.services.impl.jugador.ListarJugadorServiceImp;
import com.infotpi.utils.ControlarEntradaDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;
import static com.infotpi.utils.UtilsScanner.SCANNER;

public class ControladorEquipo extends Controlador{

    private int opcion;
    private CrearEquipoService crearEquipo = new CrearEquipoServiceImp();
    private IncorporarJugadorService incorporarJugador = new IncorporarJugadorServiceImp();
    private ListarEquipoService listarEquipo = new ListarEquipoServiceImp();
    private ListarJugadorService listarJugadores = new ListarJugadorServiceImp();
    private TransferirJugadorService transferirJugador = new TransferirJugadorServiceImp();
    
    public  void iniciar(RepositorioDeDatos repositorioDeDatos){

        do {

            Menu.menuEquipos();
            this.opcion = ControlarOpcionesMenu.opcionesMenuEquipo();
            List<Equipo> equipos = listarEquipo.listar(repositorioDeDatos);
    
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

                        System.out.println("Primero debe crear Jugadores o Equipos");
                        continue;
                    } 
                    System.out.println("Elija el equipo al que quiere ingresar el jugador: ");
                    
                    int indice = 0;
                    for (Equipo equipo : equipos){

                        
                        System.out.printf("[%d] %s\n", indice, equipo.getNombre());
                        indice++; 
                    }

                    int opcionEquipo = 0;

                    System.out.println("Elije un equipo: ");
                    opcionEquipo = ControlarEntradaDatos.controlarEntradaDeDatos(equipos.size());

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

                    System.out.println("Elije un jugador: ");
                    
                    opcionJugador = ControlarEntradaDatos.controlarEntradaDeDatos(listarJugadores.listarSinEquipo(repositorioDeDatos).size());


                    incorporarJugador.incorporar(equipos.get(opcionEquipo), listarJugadores.listarSinEquipo(repositorioDeDatos).get(opcionJugador));

                    break;

                case 3:

                    if (repositorioDeDatos.getEquipoVacio() || repositorioDeDatos.getJugadoresVacio()){

                        System.out.println("Primero debe crear Jugadores o Equipos");
                        continue;
                    } 

                    
                    List<Jugador> jugadoresConEquipo = listarJugadores.listarConEquipo(repositorioDeDatos);
                    indice = 0;
                    opcionJugador = 0;
                    opcionEquipo = 0;
                    
                    System.out.println("Elija al jugador que desea transferir");

                    for (Jugador jugador : jugadoresConEquipo){

                        System.out.printf("[%d] Jugador: %s - Equipo: %s\n", indice, jugador.getNombre(), jugador.getEquipo().getNombre());
                        indice++;
                    }
                    
                    opcionJugador = ControlarEntradaDatos.controlarEntradaDeDatos(jugadoresConEquipo.size());


                    System.out.println("Elije a que equipo transferir el jugador: ");

                    indice = 0;
                    for (Equipo equipo : equipos){
                        
                        System.out.printf("[%d] %s\n", indice, equipo.getNombre());
                        indice++;
                    }

                    
                    System.out.println("Elije un Equipo: ");
                    
                    while(Boolean.TRUE){

                        opcionEquipo = ControlarEntradaDatos.controlarEntradaDeDatos(equipos.size());
                        if (equipos.get(opcionEquipo) == jugadoresConEquipo.get(opcionJugador).getEquipo()){

                            System.out.println("Error. No se puede transferir al jugador al mismo equipo. Intente nuevamente.");
                        }
                        else {
                            break;
                        }

                    }

                    


                    transferirJugador.transferir(jugadoresConEquipo.get(opcionJugador).getEquipo(), 
                                                equipos.get(opcionEquipo),
                                                jugadoresConEquipo.get(opcionJugador));

                    break;
            }



            
        

        } while(this.opcion != 0);

    }
}

