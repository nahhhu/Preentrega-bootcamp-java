package main;

import excepciones.ErrorMenu;
import menu.Menu;

public class Main {
    public static void main(String[] args) {

        try {
            Menu.mostrarMenu();
        } catch (ErrorMenu e) {
            throw new ErrorMenu("Ha ocurrido un error inesperado");
        }

    }
}
