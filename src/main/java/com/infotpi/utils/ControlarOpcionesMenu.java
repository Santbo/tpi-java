package com.infotpi.utils;

public class ControlarOpcionesMenu {
    
    public static boolean opcionesMenu(int opcion){

            return opcion > Menu.OPCIONES_MENU || opcion < Menu.OPCION_SALIR;

    }
    public static boolean opcionesMenuJugador(int opcion){

            return opcion > Menu.OPCIONES_JUGADORES || opcion < Menu.OPCION_SALIR;

    }
    public static boolean opcionesMenuEquipo(int opcion){

            return opcion > Menu.OPCIONES_EQUIPOS || opcion < Menu.OPCION_SALIR;

    }

}
