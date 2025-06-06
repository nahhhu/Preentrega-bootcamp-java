package productos;

import excepciones.DatoInvalidoException;
import interfaces.Actualizable;
import interfaces.Informativo;
import util.FormateoCadena;
import util.Input;
public class Bebidas extends Producto implements Actualizable, Informativo {
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
        if (tipo != null && !tipo.trim().isEmpty()) {
            this.tipo = tipo;
        } else {
            throw new DatoInvalidoException("El tipo de bebida no puede estar vacio.");
        }
    }

    @Override
    public void actualizar(){
        String nombre = Input.texto("Ingrese el nombre");
        setNombre(FormateoCadena.capitalizar(nombre));
        String tipo = Input.texto("Ingrese el tipo");
        setTipo(FormateoCadena.capitalizar(tipo));
        double litros = Input.decimal("Ingrese la cantidad de litros");
        setLitros(litros);
        double precio = Input.decimal("Ingrese el precio");
        setPrecio(precio);
        int stock = Input.entero("Ingrese la cantidad de stock");
        setStock(stock);
    }

    public  String formatearTexto(){
        return "ID: " + getId() + "\nNombre: " + FormateoCadena.capitalizar(getNombre()) + "\nTipo: " + FormateoCadena.capitalizar(getTipo())+ "\nLitros: " + getLitros() + "\nPrecio: $" + getPrecio() + "\nStock: " +getStock();
    }
}
