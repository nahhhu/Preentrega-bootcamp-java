package main;

import excepciones.ErrorMenuException;
import menu.Menu;

public class Main {
    public static void main(String[] args) {

        try {
            Menu.mostrarMenu();
        } catch (ErrorMenuException e) {
            throw new ErrorMenuException("Ha ocurrido un error inesperado");
        }

    }
}
