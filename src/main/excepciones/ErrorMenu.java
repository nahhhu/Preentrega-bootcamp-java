package excepciones;

public class ErrorMenu extends RuntimeException {
    public ErrorMenu(String message) {
        super(message);
    }
}
