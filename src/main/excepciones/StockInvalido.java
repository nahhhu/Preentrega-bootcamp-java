package excepciones;

public class StockInvalido extends RuntimeException {
    public StockInvalido(String message) {
        super(message);
    }
}
