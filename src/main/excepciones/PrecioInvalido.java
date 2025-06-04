package excepciones;

public class PrecioInvalido extends RuntimeException {
    public PrecioInvalido(String message) {
        super(message);
    }
}
