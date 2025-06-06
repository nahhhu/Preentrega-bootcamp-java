package productos;

import excepciones.DatoInvalidoException;
import interfaces.Actualizable;
import interfaces.Informativo;
import util.FormateoCadena;
import util.Input;

public class Comida extends Producto implements Actualizable, Informativo {
    private String marca;
    private double peso;

    public Comida(String nombre, String marca, double peso, double precio, int stock) {
        super(nombre, precio, stock);
        setMarca(marca);
        setPeso(peso);
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        if (marca != null && !marca.trim().isEmpty()) {
            this.marca = marca;
        } else {
            throw new DatoInvalidoException("Debe decir de que marca es el producto, no puede ingresar un dato nulo");
        }
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        if (peso >= 1) {
            this.peso = peso;
        } else {
            throw new DatoInvalidoException("El peso no puede ser negativo ni 0");
        }
    }

    @Override
    public void actualizar(){
        String nombre = Input.texto("Ingrese el tipo de alimento");
        setNombre(FormateoCadena.capitalizar(nombre));
        String marca = Input.texto("Ingrese la marca");
        setMarca(FormateoCadena.capitalizar(marca));
        double peso = Input.decimal("Ingrese el peso");
        setPeso(peso);
        double precio = Input.decimal("Ingrese el precio");
        setPrecio(precio);
        int stock = Input.entero("Ingrese la cantidad");
        setStock(stock);
    }
    public  String formatearTexto(){
        return "ID: " + getId() + "\nNombre: " + FormateoCadena.capitalizar(getNombre()) + "\nmarca: " + FormateoCadena.capitalizar(getMarca()) + "\nPeso: " + getPeso() + "\nPrecio: $" + getPrecio() + "\nStock: " +getStock();
    }
}
