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
        boolean continuar =  true;

        while (continuar){
            inventario.mostrarProductos();
            String opcion = Input.texto("Ingrese el id/nombre del producto");
            Producto p = inventario.buscarProductoPorIdONombre(opcion);
            int cantidad = Input.entero("Ingrese la cantidad");

            if (opcion != null && cantidad <= p.getStock()) {
                pedido.agregarLinea(new LineaPedido(p, cantidad));
                p.reducirStock(cantidad);
                pedidos.add(pedido);
                System.out.println("EL pedido se ha creado");
                String avanzar =Input.texto("Quiere agregar mas productos?  si|no");
                if (avanzar.equals("si")){
                    continue;
                } else if (avanzar.equals("no")) {
                    continuar = false;
                }
            }
        }
    }

    public void mostrarPedido(){
        if (!pedidos.isEmpty()){
            for (Pedido p : pedidos){
               toString();
            }
        }else {
            System.out.println("No hay pedidos creados");
        }
    }
}

