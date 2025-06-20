package com.infotpi.services.impl.equipo;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.entidades.Jugador;
import com.infotpi.services.impl.jugador.ListarJugadorServiceImp;
import com.infotpi.services.interfaces.ExportarJugadoresEquipoService;
import com.infotpi.services.interfaces.ListarJugadorService;
import com.opencsv.CSVWriter;

public class ExportarJugadoresEquipoServiceImp implements ExportarJugadoresEquipoService{
    
    private final String UBICACION_ARCHIVO = "\\src\\main\\java\\com\\infotpi\\recursos\\";
    CSVWriter csvWriter;
    private ListarJugadorService listarJugadores = new ListarJugadorServiceImp();

    @Override
    public void exportarJugadoresEquipoCSV(List<Jugador> jugadores, RepositorioDeDatos repositorioDeDatos){

        String ruta = System.getProperty("user.dir").concat(UBICACION_ARCHIVO).concat(String.format("jugadores-equipo-%s.csv", jugadores.get(0).getEquipo()));
        
        try{

            this.csvWriter = new CSVWriter(new FileWriter(ruta));

            String[] encabezado = {"ES TITULAR","NOMBRE", "EDAD", "CANTIDAD DE GOLES"};
            this.csvWriter.writeNext(encabezado);

            listarJugadores.listar(repositorioDeDatos).forEach((jugador, tipo)->{

                if(jugador.getEquipo().equals(jugadores.get(0).getEquipo())){

                    String [] datos = {
                        (tipo.equals("Titular")) ? "Si" : "No",
                        jugador.getNombre(),
                        Integer.toString(jugador.getEdad()),
                        Integer.toString(jugador.getGolesHistoricos()),
                        
                    };

                    this.csvWriter.writeNext(datos);
                }
            });

            //Cerrar el csvWriter
            System.out.println("Exportacion exitosa");
            this.cerrarWriter();

        }catch (IOException e){
            System.out.println("Algo salio mal motivo :" + e.getMessage().concat(" Ubicacion archivo : " + ruta));
        }
    
    }

    private void cerrarWriter() {
        if (this.csvWriter != null){
            try{
                this.csvWriter.close();
            }catch (IOException e){
                System.out.println("Algo salio mal motivo :" + e.getMessage());
            }
        }
    }

}
