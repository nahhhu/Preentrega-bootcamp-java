package menu;

import excepciones.OpcionIncorrecta;
import util.Input;

public class Menu {
    public static void mostrarMenu() {
        while (true) {
            System.out.println("1) Agregar producto");
            System.out.println("2) Listar producto");
            System.out.println("3) Buscar/Actualizar producto");
            System.out.println("4) Eliminar producto");
            System.out.println("5) Crear pedido");
            System.out.println("6) Listar pedidos");
            System.out.println("7) Salir");

            int opcion = Input.entero("Seleccione una opcion: ");

            if (opcion == 1) {
                System.out.println("Agregue un producto: ");
            } else if (opcion == 2) {
                System.out.println("Lista de productos: ");
            } else if (opcion == 3) {
                System.out.println("Busque o actualice su producto: ");
            } else if (opcion == 4) {
                System.out.println("Elimine un producto: ");
            } else if (opcion == 5) {
                System.out.println("Cree un pedido: ");
            } else if (opcion == 6) {
                System.out.println("Lisa de pedidos:");
            } else if (opcion == 7) {
                break;
            } else {
                throw new OpcionIncorrecta("Ingresa una opcion valida");
            }
        }
    }
}
