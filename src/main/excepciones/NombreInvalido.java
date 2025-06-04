package excepciones;

public class NombreInvalido extends RuntimeException {
    public NombreInvalido(String message) {
        super(message);
    }
}
