package pedidos;

import interfaces.Informativo;
import productos.Producto;

public class LineaPedido implements Informativo {
    private Producto producto;
    private int cantidad;

    public LineaPedido(Producto producto, int cantidad){
        this.producto = producto;
        this.cantidad = cantidad;
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

    @Override
    public String formatearTexto() {
        return producto.getNombre()  + " x" + cantidad  + " = $" + calcularSubTotal();
    }

    @Override
    public String toString() {
        return formatearTexto();
    }
}
