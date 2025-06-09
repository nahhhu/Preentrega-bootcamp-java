package pedidos;

import java.util.ArrayList;
import java.util.List;

public class Pedido {
    private static int contador = 0;
    private final int id;
    private List<LineaPedido> lineas;

    public Pedido(){
        this.id = ++contador;
        this.lineas = new ArrayList<>();
    }

    public void agregarLinea (LineaPedido  linea){
        lineas.add(linea);
    }

    public double calcularTotal(){
        double total =  0;
        for (LineaPedido l  : lineas){
            total  += l.calcularSubTotal();
        }
        return total;
    }

    public List<LineaPedido> getLineas() {
        return lineas;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Pedido #" + id + "\n");
        for (LineaPedido l : lineas) {
            sb.append(l.toString()).append("\n");
        }
        sb.append("Total: $").append(calcularTotal());
        return sb.toString();
    }
}
