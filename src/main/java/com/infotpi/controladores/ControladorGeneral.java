package com.infotpi.controladores;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorGeneral {

    public static void iniciar(RepositorioDeDatos repositorioDeDatos){

        Controlador controladorEquipo = new ControladorEquipo();
        Controlador controladorJugador = new ControladorJugador();
        int opcion;
        do {
            
            Menu.menu();
            opcion = ControlarOpcionesMenu.opcionesMenuJugador();
            
            switch(opcion){
                case 1: 
                    controladorJugador.iniciar(repositorioDeDatos);
                    break;
                case 2:
                    controladorEquipo.iniciar(repositorioDeDatos);
                    break;
            }
        } while (opcion != 0);
    }

}
