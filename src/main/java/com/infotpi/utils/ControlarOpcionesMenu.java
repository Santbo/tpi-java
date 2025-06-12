package com.infotpi.utils;

import java.util.Scanner;

public class ControlarOpcionesMenu {

    
    public static int convertirOpciones(){
        
        Scanner scanner = new Scanner(System.in);
        do {

            try {
                
                System.out.println("Elija una opcion: ");
                String opcion = scanner.nextLine(); 
                int opciones = Integer.parseInt(opcion);

                scanner.close();
    
                return opciones;
            } catch (NumberFormatException e) {
    
                System.out.println("Error, opcion inválida. Intente nuevamente");
            }
        } while (Boolean.TRUE);

        return -1;
    }
    
    public static int opcionesMenu(){

        int opcion = convertirOpciones();
        while(opcion > Menu.OPCIONES_MENU || opcion < Menu.OPCION_SALIR) {

            System.out.println("La opcion seleccionada es incorrecta. Elija una opcion válida");
            opcion = convertirOpciones();
        } 

        return opcion;

    }
    
    public static int opcionesMenuJugador(){

        
        int opcion = convertirOpciones();
        while(opcion > Menu.OPCIONES_JUGADORES || opcion < Menu.OPCION_SALIR) {

            System.out.println("La opcion seleccionada es incorrecta. Elija una opcion válida");
            opcion = convertirOpciones();
        } 

        return opcion;

    }
    public static int opcionesMenuEquipo(){

        
        int opcion = convertirOpciones();
        while(opcion > Menu.OPCIONES_EQUIPOS || opcion < Menu.OPCION_SALIR) {

            System.out.println("La opcion seleccionada es incorrecta. Elija una opcion válida");
            opcion = convertirOpciones();
        } 

        return opcion;

    }

}
