package excepciones;

public class InventarioVacioException extends RuntimeException {
    public InventarioVacioException(String message) {
        super(message);
    }
}
