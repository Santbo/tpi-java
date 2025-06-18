package com.infotpi.utils;

import static com.infotpi.utils.UtilsScanner.SCANNER;

public class ControlarEntradaDatos {
    


    public static int controlarEntradaDeDatos(int tamanioLista){

        int opcion = 0;
        String scan;
        while(Boolean.TRUE){

            System.out.println("Elije una opcion: ");
            scan = SCANNER.nextLine();
            opcion = Integer.parseInt((scan.isEmpty())? "-1" : scan );
             if (opcion < 0 || opcion >= tamanioLista) {
    
                System.out.println("Error al elegir la opción. Intente nuevamente.");
                continue;
            }

            break;
        }

        return opcion;

    }
}
