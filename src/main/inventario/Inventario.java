package inventario;

import excepciones.DatoInvalidoException;
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

    /*Muestra por consola los datos comunes entre productos
     * Muestra tambien los datos especificos de cada producto*/
    public void mostrarProductos() {
        for (Producto p : productos) {
            System.out.println("-------------------------");
            System.out.println("ID: " + p.getId());
            System.out.println("Nombre: " + p.getNombre());
            System.out.println("Precio: " + p.getPrecio());
            System.out.println("Cantidad en Stock: " + p.getStock());
            //Datos especificos
            if (p instanceof Bebidas b) {
                System.out.println("Tipo: " + b.getTipo());
                System.out.println("Litros: " + b.getLitros() + "Lts");
            } else if (p instanceof Comida c) {
                System.out.println("Marca: " + c.getMarca());
                System.out.println("Peso: " + c.getPeso() + "Kg");
            } else if (p instanceof Infusiones i) {
                System.out.println("Tipo: " + i.getTipo());
                System.out.println("Peso: " + i.getGramos() + "kg");
            }
        }
    }

    public void buscarYActualizarProducto() {
        String idProducto = Input.texto("Ingrese el ID (número) o nombre del producto que desea actualizar: ");
        boolean encontro = false;
        for (Producto p : productos) {
            try {
                int id = Integer.parseInt(idProducto);
                if (p.getId() == id) {
                    actualizarProducto(p);
                    encontro = true;
                    break;
                }else if (p.getNombre().equalsIgnoreCase(idProducto.trim())) {
                    actualizarProducto(p);
                    encontro = true;
                    break;
                }
            } catch (DatoInvalidoException e) {
                System.out.println("Producto no encontrado" +  e);
            }
        }
    }

    public void actualizarProducto(Producto p) {
        try {
            String tipoProducto = Input.texto("Ingrese el tipo de producto a actualizar: Bebidas| Infusiones| Comida");
            String tipoProductoFormateado = FormateoCadena.capitalizar(tipoProducto);
            if (tipoProductoFormateado.equalsIgnoreCase("Bebidas") && p instanceof Bebidas b) {
                String nombre = Input.texto("Ingrese el nombre");
                b.setNombre(nombre);
                String tipo = Input.texto("Ingrese el tipo");
                b.setTipo(tipo);
                double litros = Input.decimal("Ingrese la cantidad de litros");
                b.setLitros(litros);
                double precio = Input.decimal("Ingrese el precio");
                b.setPrecio(precio);
                int stock = Input.entero("Ingrese la cantidad de stock");
                b.setStock(stock);
            } else if (tipoProductoFormateado.equalsIgnoreCase("Comida") && p instanceof Comida) {
                Comida c = (Comida) p;
                String nombre = Input.texto("Ingrese el nombre");
                c.setNombre(nombre);
                String marca = Input.texto("Ingrese el marca");
                c.setMarca(marca);
                double peso = Input.decimal("Ingrese el peso");
                c.setPeso(peso);
                double precio = Input.decimal("Ingrese el precio");
                c.setPrecio(precio);
                int stock = Input.entero("Ingrese la cantidad de stock");
                c.setStock(stock);
            } else if (tipoProductoFormateado.equalsIgnoreCase("Infusiones") && p instanceof Infusiones ) {
                Infusiones in = (Infusiones) p;
                String nombre = Input.texto("Ingrese el nombre");
                in.setNombre(nombre);
                String tipo = Input.texto("Ingrese el tipo");
                in.setTipo(tipo);
                double gramos = Input.decimal("Ingrese el peso");
                in.setGramos(gramos);
                double precio = Input.decimal("Ingrese el precio");
                in.setPrecio(precio);
                int stock = Input.entero("Ingrese la cantidad de stock");
                in.setStock(stock);
            }
        }catch (DatoInvalidoException e){
            System.out.println(e  + "Error el dato ingresado es invalido");
        }
    }
}

