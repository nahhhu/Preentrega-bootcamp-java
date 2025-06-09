package inventario;

import excepciones.DatoInvalidoException;
import excepciones.InventarioVacioException;
import interfaces.Actualizable;
import interfaces.Informativo;
import interfaces.Eliminable;
import productos.Bebidas;
import productos.Comida;
import productos.Infusiones;
import productos.Producto;
import util.FormateoCadena;
import util.Input;

import java.util.ArrayList;

public class Inventario {
    private final ArrayList<Producto> productos = new ArrayList<>();

    //Agrega productos dependiendo que tipoo de producto es
    public void agregarProducto() {
        //Pide el tipo de producto y se capitaliza para evitar errores
        String tipoProducto = Input.texto("Selecciones el tipo de producto que desea agregar: Bebidas; Comida; Infusiones");
        String tipoProductoFormateado = FormateoCadena.capitalizar(tipoProducto);

        if (tipoProductoFormateado.equals("Bebidas")) {
            String nombre = Input.texto("Ingrese el nombre del producto:");
            String tipo = Input.texto("Ingrese el tipo de bebida:");
            double litros = Input.decimal("Ingrese la cantidad en litros:");
            double precio = Input.decimal("Ingrese el precio:");
            int stock = Input.entero("Ingrese el stock:");

            productos.add(new Bebidas(nombre, tipo, litros, precio, stock));

        } else if (tipoProductoFormateado.equals("Comida")) {
            String nombre = Input.texto("Ingrese el nombre del producto:");
            String marca = Input.texto("Ingrese la marca de la comida:");
            double peso = Input.decimal("Ingrese el peso de la comida");
            double precio = Input.decimal("Ingrese el precio:");
            int stock = Input.entero("Ingrese el stock:");

            productos.add(new Comida(nombre, marca, peso, precio, stock));
        } else if (tipoProductoFormateado.equals("Infusiones")) {
            String nombre = Input.texto("Ingrese el nombre del producto:");
            String tipo = Input.texto("Ingrese el tipo de infusion:");
            double gramos = Input.decimal("Ingrese el peso del producto:");
            double precio = Input.decimal("Ingrese el precio del producto:");
            int stock = Input.entero("Ingrese el stock:");
            productos.add(new Infusiones(nombre, tipo, gramos, precio, stock));
        } else {
            throw new DatoInvalidoException("El tipo de producto seleccionado no existe");
        }
    }

    // Muestra tambien los datos especificos de cada producto/
    public void mostrarProductos() {
        if (productos.isEmpty()){
            System.out.println("El inventario esta vacio");
            return;
        }
        for (Producto p : productos) {
            System.out.println("-------------------------");
            if (p instanceof Informativo f) {
                System.out.println(f.formatearTexto());
            }
        }
    }

    public void buscarYActualizarProducto() {
        String idProducto = Input.texto("Ingrese el ID (número) o nombre del producto que desea actualizar: ").trim();
        System.out.println("-------------------------");
        for (Producto p : productos) {
            try {
                System.out.println("Encontrado!");
                int id = Integer.parseInt(idProducto);
                if (p.getId() == id) {
                    actualizarProducto(p);
                    return;
                }
            } catch (NumberFormatException e) {
                // Si no es un número lo pasamos a comparar por nombre
                if (p.getNombre().equalsIgnoreCase(idProducto)) {
                    actualizarProducto(p);
                    return;
                }
            }
        }
        System.out.println("Producto no encontrado.");
    }

    public void actualizarProducto(Producto p) {
        if (p instanceof Actualizable a) {
            try {
                a.actualizar();
            } catch (DatoInvalidoException e) {
                System.out.println("Error: el dato ingresado es inválido. " + e.getMessage());
            }
        } else {
            System.out.println("Este producto no puede ser actualizado.");
        }
    }


    public void eliminar() {
        if (productos.isEmpty()) {
            System.out.println("No hay productos para eliminar");
        }

        mostrarProductos();
        int id = Input.entero("Ingrese el ID del producto que quiere eliminar");
        Producto productoEliminar  = null;

        String confirmacion = Input.texto("Si desea eliminar confirme SI | NO");
        if (confirmacion.equals("SI")){
            for (Producto p : productos){
                if (p.getId() == id){
                    productoEliminar = p ;
                    break;
                }
            }
            if (productoEliminar !=  null){
                productos.remove(productoEliminar);
                System.out.println("Se ha eliminado el producto");
            }else {
                System.out.println("No se encontro el producto");
            }
        }else {
            return;
        }
    }
    public Producto buscarProductoPorIdONombre(String input) {
        try {
            int id = Integer.parseInt(input);
            for (Producto p : productos) {
                if (p.getId() == id) return p;
            }
        } catch (NumberFormatException e) {
            for (Producto p : productos) {
                if (p.getNombre().equalsIgnoreCase(input)) return p;
            }
        }
        return null;
    }
}