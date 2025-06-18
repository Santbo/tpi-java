package com.infotpi.controladores;

import static com.infotpi.utils.UtilsScanner.SCANNER;

import java.util.HashMap;
import java.util.Map;

import com.infotpi.config.Configuracion;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Jugador;
import com.infotpi.entidades.Liga;
import com.infotpi.entidades.Partido;
import com.infotpi.services.impl.liga.CrearLigaServiceImp;
import com.infotpi.services.impl.liga.ListarLigaServiceImp;
import com.infotpi.services.interfaces.CrearLigaService;
import com.infotpi.services.interfaces.ListarLigasService;
import com.infotpi.utils.ControlarEntradaDatos;
import com.infotpi.utils.ControlarOpcionesMenu;
import com.infotpi.utils.Menu;

public class ControladorLiga extends Controlador{
    
    private int opcion;
    private CrearLigaService crearLiga = new CrearLigaServiceImp();
    private ListarLigasService listarLiga = new ListarLigaServiceImp();
    
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

                case 2:

                    if(repositorioDeDatos.getLiga().isEmpty()){

                        System.out.println("Error. No hay ligas creadas.");
                        continue;
                    }

                    System.out.println("Elije la liga para saber el goleador de ésta: ");

                    int indice = 0;
                    for (Liga liga : listarLiga.listar(repositorioDeDatos)){

                        System.out.printf("[%d] %s\n", indice, liga.getNombre());
                        indice++; 
                    }

                    int opcion = ControlarEntradaDatos.controlarEntradaDeDatos(listarLiga.listar(repositorioDeDatos).size());
                    Map<Jugador, Integer> goleadores = new HashMap<>();
                    Jugador jugadorGoleador = null; 
                    int maxGoles= -1;

                    

                    Liga liga = listarLiga.listar(repositorioDeDatos).get(opcion);

                    if (liga.getPartidos().isEmpty()){

                        System.out.println("Error. No hay partidos jugados en esta liga");
                        continue;
                    }

                    for (Partido partido : liga.getPartidos()) {

                        partido.getGoles().forEach((jugador, goles) -> {
                            goleadores.put(jugador, goleadores.getOrDefault(jugador, 0) + goles);
                        });
                    }

                    for (Map.Entry<Jugador, Integer> entry : goleadores.entrySet()) {

                        if (entry.getValue() > maxGoles) {
                            jugadorGoleador = entry.getKey();
                            maxGoles = entry.getValue();
                        }
                    }

                    if (jugadorGoleador != null) {
                        System.out.println("El máximo goleador es: " + jugadorGoleador.getNombre() + " con " + maxGoles + " goles.");
                    } else {
                        System.out.println("No hay goles registrados.");
                    }

                    
                    break;

            }

        } while (this.opcion != 0);
    }
}
