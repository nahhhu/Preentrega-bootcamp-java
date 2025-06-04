package productos;

public class Bebidas extends Producto {
    private String tipo;
    private double litros;

    public Bebidas(String nombre, String tipo, double litros, double precio, int stock) {
        super(nombre, precio, stock);
        setTipo(tipo);
        setLitros(litros);
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

}
