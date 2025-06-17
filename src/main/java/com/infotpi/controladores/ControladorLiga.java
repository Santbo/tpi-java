package com.infotpi.controladores;

import static com.infotpi.utils.UtilsScanner.SCANNER;

import com.infotpi.config.Configuracion;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.services.impl.liga.CrearLigaServiceImp;
import com.infotpi.services.interfaces.CrearLigaService;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorLiga {
    
    private int opcion;
    private CrearLigaService crearLiga = new CrearLigaServiceImp();
    public void iniciar(RepositorioDeDatos repositorioDeDatos){
        
        do{
            Menu.menuLiga();
            this.opcion = ControlarOpcionesMenu.opcionesMenuLiga();

            switch(this.opcion){

                case 1:

                    if (repositorioDeDatos.getLiga() != null && 
                    repositorioDeDatos.getLiga().size() >= Configuracion.MAXIMO_LIGAS) {

                        System.out.println("Error. Se alcanzó la capacidad máxima de ligas que se pueden crear.");
                        break;
                    }
                    System.out.print("Ingrese el nombre de la Liga: ");
                    String nombre = SCANNER.nextLine();

                    repositorioDeDatos.guardarLiga(crearLiga.crear(nombre));
                        
                    break;

            }

        } while (this.opcion != 0);
    }
}
