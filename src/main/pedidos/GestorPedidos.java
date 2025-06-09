package pedidos;

import inventario.Inventario;
import productos.Producto;
import util.Input;

import java.util.ArrayList;


public class GestorPedidos {
    private final ArrayList<Pedido> pedidos = new ArrayList<>();
    private final Inventario inventario;

    public GestorPedidos(Inventario inventario) {
        this.inventario = inventario;
    }

    public void crearPedido() {
        Pedido pedido = new Pedido();
        boolean continuar = true;

        while (continuar){
            inventario.mostrarProductos();
            String opcion = Input.texto("Ingrese el id/nombre del producto");
            Producto p = inventario.buscarProductoPorIdONombre(opcion);
            int cantidad = Input.entero("Ingrese la cantidad");

            if (p != null && cantidad <= p.getStock()) {
                pedido.agregarLinea(new LineaPedido(p, cantidad));
                p.reducirStock(cantidad);
            } else {
                System.out.println("Stock insuficiente o producto no encontrado.");
            }

            String avanzar = Input.texto("¿Quiere agregar más productos?  si|no");
            if (!avanzar.equalsIgnoreCase("si")) {
                continuar = false;
            }
        }
        pedidos.add(pedido);
        System.out.println("El pedido se ha creado");
    }

    public void mostrarPedido(){
        if (!pedidos.isEmpty()){
            for (Pedido p : pedidos){
                System.out.println(p);
            }
        }else {
            System.out.println("No hay pedidos creados");
        }
    }
}

