package menu;

import excepciones.OpcionIncorrectaException;
import inventario.Inventario;
import pedidos.GestorPedidos;
import util.Input;

public class Menu {
    public static void mostrarMenu() {
        Inventario inventario = new Inventario();
        GestorPedidos pedido = new GestorPedidos(inventario);
        while (true) {
            System.out.println("+------------------------------------------+");
            System.out.println("|              MENÚ PRINCIPAL              |");
            System.out.println("+------------------------------------------+");
            System.out.println("| 1) Agregar producto                      |");
            System.out.println("| 2) Listar producto                       |");
            System.out.println("| 3) Buscar / Actualizar producto          |");
            System.out.println("| 4) Eliminar producto                     |");
            System.out.println("| 5) Crear pedido                          |");
            System.out.println("| 6) Listar pedidos                        |");
            System.out.println("| 7) Salir                                 |");
            System.out.println("+------------------------------------------+");

            int opcion = Input.entero("Seleccione una opcion: ");

            if (opcion == 1) {
                System.out.println("Agregue un producto: ");
                inventario.agregarProducto();
            } else if (opcion == 2) {
                System.out.println("Lista de productos: ");
                inventario.mostrarProductos();
            } else if (opcion == 3) {
                System.out.println("Busque y actualice su producto: ");
                inventario.buscarYActualizarProducto();
            } else if (opcion == 4) {
                System.out.println("Elimine un producto: ");
                inventario.eliminar();
            } else if (opcion == 5) {
                System.out.println("Cree un pedido: ");
                pedido.crearPedido();
            } else if (opcion == 6) {
                System.out.println("Lista de pedidos:");
                pedido.mostrarPedido();
            } else if (opcion == 7) {
                break;
            } else {
                throw new OpcionIncorrectaException("Ingresa una opcion valida");
            }
        }
    }
}
