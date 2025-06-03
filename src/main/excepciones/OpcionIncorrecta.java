package excepciones;

public class OpcionIncorrecta extends RuntimeException {
    public OpcionIncorrecta(String mensaje) {
        super(mensaje);
    }
}
