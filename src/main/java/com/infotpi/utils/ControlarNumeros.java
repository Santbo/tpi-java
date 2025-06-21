package com.infotpi.utils;

public class ControlarNumeros {
    
    public static boolean esEnteroValido(String numero){

        try{

            Integer.parseInt(numero);

            return true;
        } catch (NumberFormatException e) {

            return false;
        }
    }
}
