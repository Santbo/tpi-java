package com.infotpi.utils;

public class Menu {
    
    static final int OPCIONES_MENU = 4;
    static final int  OPCIONES_JUGADORES= 6;  
    static final int OPCIONES_EQUIPOS = 5;  
    static final int OPCION_SALIR = 0;
    static final int OPCIONES_PARTIDO = 2;
    static final int OPCIONES_PARTIDO_EN_VIVO = 3;  
    static final int OPCIONES_LIGA = 2;  
    
    public static void presentacion(){

        System.out.println("BIENVENIDO AL SISTEMA DEL TPI");
    }

    public static void menu(){

        System.out.println("=========================");
        System.out.println("¿CON CUAL DESEA TRABAJAR?");
        System.out.println("[1] Menu Jugadores");
        System.out.println("[2] Menu Equipos");
        System.out.println("[3] Menu Partidos");
        System.out.println("[4] Menu Liga");
        System.out.println("[0] Salir");
        
    }

    public static void menuJugadores(){

        System.out.println("=========================");
        System.out.println("[1] Registrar Jugador Titular");
        System.out.println("[2] Registrar Jugador Suplente");
        System.out.println("[3] Listar todos los Jugadores");
        System.out.println("[4] Listar Suplentes que no ingresaron a partidos");
        System.out.println("[5] Obtener el jugador con mas partidos ingresados");
        System.out.println("[6] Calculo de eficiencia de cada jugador");
        System.out.println("[0] Volver atras");
        
        
    }
    
    public static void menuEquipos(){
        
        System.out.println("=========================");
        System.out.println("[1] Registrar Equipo");
        System.out.println("[2] Incorporar Jugador a un Equipo");
        System.out.println("[3] Transferir Jugador");
        System.out.println("[4] Ranking de Equipos por Goles");
        System.out.println("[5] Exportar jugadores de un equipo");
        System.out.println("[0] Volver atras");
        
        
    }

    public static void menuPartidos(){

        System.out.println("=========================");
        System.out.println("[1] Crear partido");
        System.out.println("[2] Promedio de goles de todos los equipos");
        System.out.println("[0] Volver atras");
    }

    public static void partidoEnVivo(){

        System.out.println("=========================");
        System.out.println("[1] Meter Gol");
        System.out.println("[2] Terminar Partido 0 - 0");
        System.out.println("[3] Finalizar Partido");
        System.out.println("[0] Cancelar Partido");

    }

    public static void menuLiga(){
        System.out.println("=========================");
        System.out.println("[1] Crear Liga");
        System.out.println("[2] Goleador de Liga");
        System.out.println("[0] Volver atras");
        
    }
}
