package com.infotpi.controladores;

import java.util.Scanner;

import com.infotpi.services.interfaces.CrearEquipoService;
import com.infotpi.services.interfaces.IncorporarJugadorService;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.services.impl.equipo.CrearEquipoServiceImp;
import com.infotpi.services.impl.equipo.IncorporarJugadorServiceImp;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorEquipo extends Controlador{

    private int opcion;
    private Scanner scanner = new Scanner(System.in);
    private CrearEquipoService crearEquipo = new CrearEquipoServiceImp();
    private IncorporarJugadorService incorporarJugador = new IncorporarJugadorServiceImp();
    private RepositorioDeDatos data = new RepositorioDeDatos();
    
    
    public void iniciar(){

        do {

            Menu.menuEquipos();
            this.opcion = ControlarOpcionesMenu.opcionesMenuEquipo();
    
            switch (this.opcion) 
            {

                case 1: 
                    System.out.print("Ingrese el nombre del Equipo: ");
                    String nombre = scanner.nextLine();

                    crearEquipo.crear(nombre);
                        
                    break;
                
                case 2: 
                    
                    if (data.getEquipoVacio() || data.getJugadoresVacio()){

                        System.out.println("Primero debe crear Jugadores y Equipos");
                        continue;
                    }

                    incorporarJugador.incorporar(null, null);


            }
        

        } while(this.opcion != 0);

    }
}

