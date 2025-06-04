package util;

public class FormateoCadena {
    public static String capitalizar(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return "";
        }

        String[] palabras = texto.trim().toLowerCase().split("\\s+");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (palabra.length() > 0) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)));
                resultado.append(palabra.substring(1));
                resultado.append(" ");
            }
        }
        return resultado.toString().trim();
    }
}
