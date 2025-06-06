package excepciones;

public class OpcionIncorrectaException extends RuntimeException {
    public OpcionIncorrectaException(String mensaje) {
        super(mensaje);
    }
}
