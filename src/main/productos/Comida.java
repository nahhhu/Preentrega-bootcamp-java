package productos;

import excepciones.DatoInvalidoException;

public class Comida extends Producto {
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
        if (marca != null || !marca.trim().isEmpty()) {
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
}
