package productos;

import excepciones.DatoInvalido;

public class Infusiones extends Producto {
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
        if (tipo != null || !tipo.trim().isEmpty()) {
            this.tipo = tipo;
        } else {
            throw new DatoInvalido("El tipo de bebida no puede estar vacio.");
        }
    }

    public double getGramos() {
        return gramos;
    }

    public void setGramos(double gramos) {
        if (gramos >= 0) {
            this.gramos = gramos;
        } else {
            throw new DatoInvalido("Los gramos de la infucion no pueden ser 0 ni negativos.");
        }
    }
}
