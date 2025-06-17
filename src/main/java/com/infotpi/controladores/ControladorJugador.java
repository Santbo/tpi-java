package com.infotpi.controladores;

import com.infotpi.services.interfaces.ListarJugadorService;
import com.infotpi.services.interfaces.RegistrarJugadorService;
import com.infotpi.services.impl.jugador.RegistrarTitularServiceImp;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.services.impl.jugador.ListarJugadorServiceImp;
import com.infotpi.services.impl.jugador.RegistrarSuplenteServiceImp;
import com.infotpi.utils.ControlarNumeros;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.ListarJugadores;
import com.infotpi.config.Configuracion;
import com.infotpi.utils.Menu;

import static com.infotpi.utils.UtilsScanner.SCANNER;

public class ControladorJugador extends Controlador{

    private int opcion;
    private RegistrarJugadorService registrarJugadorTitular = new RegistrarTitularServiceImp();
    private RegistrarJugadorService registrarJugadorSuplente = new RegistrarSuplenteServiceImp();
    private ListarJugadorService listarJugadores = new ListarJugadorServiceImp();
    
    
    public void iniciar(RepositorioDeDatos repositorioDeDatos){

        do {

            Menu.menuJugadores();
            this.opcion = ControlarOpcionesMenu.opcionesMenuJugador();
            String nombre;
            String edad;

            if (this.opcion < 3) {

                if (repositorioDeDatos.getJugadores() != null && 
                    repositorioDeDatos.getJugadores().size() >= Configuracion.MAXIMO_JUGADORES){
    
                    System.out.println("Error, se alcanzó la cantidad máxima de jugadores que se pueden crear.");
                    break;
                }
            }
            
            switch (this.opcion) 
            {

                case 1: 
                    System.out.print("Ingrese el nombre del jugador: ");
                    nombre = SCANNER.nextLine();

                    while (Boolean.TRUE){

                        System.out.print("Ingrese la edad del jugador: ");
                        edad = SCANNER.nextLine();
    
                        if (ControlarNumeros.esEnteroValido(edad) && 
                        Integer.parseInt(edad) > 3 && 
                        Integer.parseInt(edad) < 80){
                            
                            repositorioDeDatos.guardarJugador(registrarJugadorTitular.registrar(nombre, Integer.parseInt(edad)));
                            break;
                        }

                        System.out.println("Error, edad no válida, intente nuevamente.");
                    }
                    break;
                
                case 2: 
                    System.out.print("Ingrese el nombre del jugador: ");
                    nombre = SCANNER.nextLine();

                    while (Boolean.TRUE){

                        System.out.print("Ingrese la edad del jugador: ");
                        edad = SCANNER.nextLine();
    
                        if (ControlarNumeros.esEnteroValido(edad) && 
                        Integer.parseInt(edad) > 3 && 
                        Integer.parseInt(edad) < 80){

                            repositorioDeDatos.guardarJugador(registrarJugadorSuplente.registrar(nombre, Integer.parseInt(edad)));
                            break;
                        }
                        System.out.println("Error, edad no válida, intente nuevamente.");
                    }
                    break;
                
                case 3:
                    
                    ListarJugadores.ListarTodosLosJugadores(listarJugadores.listar(repositorioDeDatos));
                    break;
                    

            }
        

        } while(this.opcion != 0);

    }
}
