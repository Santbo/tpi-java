package com.infotpi.controladores;

import java.util.Scanner;

import com.infotpi.services.interfaces.RegistrarJugadorService;
import com.infotpi.services.impl.jugador.RegistrarTitularServiceImp;
import com.infotpi.services.impl.jugador.RegistrarSuplenteServiceImp;
import com.infotpi.utils.ControlarNumeros;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorJugador extends Controlador{

    private int opcion;
    private Scanner scanner = new Scanner(System.in);
    private RegistrarJugadorService registrarJugadorTitular = new RegistrarTitularServiceImp();
    private RegistrarJugadorService registrarJugadorSuplente = new RegistrarSuplenteServiceImp();
    
    
    public void iniciar(){

        do {

            Menu.menuJugadores();
            this.opcion = ControlarOpcionesMenu.opcionesMenuJugador();
            String nombre;
            String edad;
            
            switch (this.opcion) 
            {

                case 1: 
                    System.out.print("Ingrese el nombre del jugador: ");
                    nombre = scanner.nextLine();

                    while (Boolean.TRUE){

                        System.out.print("Ingrese la edad del jugador: ");
                        edad = scanner.nextLine();
    
                        if (ControlarNumeros.esEnteroValido(edad)){
                            
                            registrarJugadorTitular.registrar(nombre, Integer.parseInt(edad));
                            break;
                        }

                        System.out.println("Error, edad no válida, intente nuevamente.");
                    }
                    break;
                
                case 2: 
                    System.out.print("Ingrese el nombre del jugador: ");
                    nombre = scanner.nextLine();

                    while (Boolean.TRUE){

                        System.out.print("Ingrese la edad del jugador: ");
                        edad = scanner.nextLine();
    
                        if (ControlarNumeros.esEnteroValido(edad)){

                            registrarJugadorSuplente.registrar(nombre, Integer.parseInt(edad));
                            break;
                        }
                        System.out.println("Error, edad no válida, intente nuevamente.");
                    }
                    break;


            }
        

        } while(this.opcion != 0);

    }
}
