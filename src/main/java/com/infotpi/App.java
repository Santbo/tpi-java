package com.infotpi;

import com.infotpi.controladores.ControladorGeneral;
import com.infotpi.data.RepositorioDeDatos;
import com.infotpi.utils.Menu;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        RepositorioDeDatos repositorioDeDatos = new RepositorioDeDatos();
        Menu.presentacion();

        ControladorGeneral.iniciar(repositorioDeDatos);

    }
}
