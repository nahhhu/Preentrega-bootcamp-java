package productos;

import excepciones.DatoInvalidoException;
import interfaces.Actualizable;
import interfaces.Informativo;
import util.FormateoCadena;
import util.Input;

public class Infusiones extends Producto implements Actualizable, Informativo {
    private String tipo;
    private double gramos;

    public Infusiones(String nombre, String tipo, double gramos, double precio, int stock) {
        super(nombre, precio, stock);
        setTipo(tipo);
        setGramos(gramos);
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        if (tipo != null && !tipo.trim().isEmpty()) {
            this.tipo = tipo;
        } else {
            throw new DatoInvalidoException("El tipo de bebida no puede estar vacio.");
        }
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        if (gramos >= 1) {
            this.gramos = gramos;
        } else {
            throw new DatoInvalidoException("Los gramos de la infucion no pueden ser 0 ni negativos.");
        }
    }
    @Override
    public void actualizar(){
        String nombre = Input.texto("Ingrese el nombre");
        setNombre(FormateoCadena.capitalizar(nombre));
        String tipo = Input.texto("Ingrese el tipo");
        setTipo(FormateoCadena.capitalizar(tipo));
        double gramos = Input.decimal("Ingrese el peso");
        setGramos(gramos);
        double precio = Input.decimal("Ingrese el precio");
        setPrecio(precio);
        int stock = Input.entero("Ingrese la cantidad de stock");
        setStock(stock);
    }
    public  String formatearTexto(){
        return "ID: " + getId() + "\nNombre: " + FormateoCadena.capitalizar(getNombre()) + "\nTipo: " + FormateoCadena.capitalizar(getTipo()) + "\nPeso: " + getGramos() + "\nPrecio: $" + getPrecio() + "\nStock: " +getStock();
    }
}
