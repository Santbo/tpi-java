package com.infotpi.controladores;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorGeneral {

    public static void iniciar(RepositorioDeDatos repositorioDeDatos){

        Controlador controladorEquipo = new ControladorEquipo();
        Controlador controladorJugador = new ControladorJugador();
        Controlador controladorPartido = new ControladorPartido();
        Controlador controladorLiga = new ControladorLiga();
        int opcion;
        do {
            
            Menu.menu();
            opcion = ControlarOpcionesMenu.opcionesMenu();
            
            switch(opcion){
                case 1: 
                    controladorJugador.iniciar(repositorioDeDatos);
                    break;
                case 2:
                    controladorEquipo.iniciar(repositorioDeDatos);
                    break;
                case 3:
                    controladorPartido.iniciar(repositorioDeDatos);
                    break;
                case 4:
                    controladorLiga.iniciar(repositorioDeDatos);
                    break;
                
                    
            }
        } while (opcion != 0);
    }

}
