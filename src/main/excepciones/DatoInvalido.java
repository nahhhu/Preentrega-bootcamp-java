package excepciones;

public class DatoInvalido extends RuntimeException {
    public DatoInvalido(String message) {
        super(message);
    }
}
