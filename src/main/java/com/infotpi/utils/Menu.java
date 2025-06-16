package com.infotpi.utils;

public class Menu {
    
    static final int OPCIONES_MENU = 3;
    static final int  OPCIONES_JUGADORES= 2;  
    static final int OPCIONES_EQUIPOS = 2;  
    static final int OPCION_SALIR = 0;  
    
    public static void presentacion(){

        System.out.println("BIENVENIDO AL SISTEMA DEL TPI");
    }

    public static void menu(){

        System.out.println("=========================");
        System.out.println("¿CON CUAL DESEA TRABAJAR?");
        System.out.println("[1] Menu Jugadores");
        System.out.println("[2] Menu Equipos");
        System.out.println("[3] Menu Partidos");
        System.out.println("[0] Salir");
        
    }

    public static void menuJugadores(){

        System.out.println("=========================");
        System.out.println("[1] Registrar Jugador Titular");
        System.out.println("[2] Registrar Jugador Suplente");
        System.out.println("[0] Volver atras");
        
        
    }
    
    public static void menuEquipos(){
        
        System.out.println("=========================");
        System.out.println("[1] Registrar Equipo");
        System.out.println("[2] Incorporar Jugador a un Equipo");
        System.out.println("[0] Volver atras");
        
        
    }
}
