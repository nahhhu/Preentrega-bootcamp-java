package productos;

import excepciones.NombreInvalidoException;
import excepciones.PrecioInvalidoException;
import excepciones.StockInvalidoException;

public abstract class Producto {

    private static int contador = 0;
    private final int id;
    private String nombre;
    private double precio;
    private int stock;

    public Producto(String nombre, double precio, int stock) {
        this.id = contador++;
        setNombre(nombre);
        setPrecio(precio);
        setStock(stock);
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {
            this.nombre = nombre;
        } else {
            throw new NombreInvalidoException("El nombre no puede estar vacio ni nulo");
        }
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio >= 1) {
            this.precio = precio;
        } else {
            throw new PrecioInvalidoException("El precio debe ser mayor que 0");
        }
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        if (stock >= 0) {
            this.stock = stock;
        } else {
            throw new StockInvalidoException("El stock no puede ser negativo");
        }
    }
}
