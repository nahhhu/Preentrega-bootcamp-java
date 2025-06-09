package pedidos;

import productos.Producto;

public class LineaPedido {
    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad){

    }

    public Producto getProducto() {
        return producto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double calcularSubTotal (){
        return producto.getPrecio() * cantidad;
    }


    public String mostrarPedidos(){
        return producto.getNombre()  + ("x") + cantidad  + ("= $") + calcularSubTotal();
    }
}
