package util;

import java.util.Scanner;

public class Input {
    private static final Scanner scanner = new Scanner(System.in);

    public static String texto(String mensaje) {
        System.out.println(mensaje);
        return scanner.nextLine();
    }

    public static int entero(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error. Ingresa un numero valido");
            }
        }
    }

    public static double decimal(String mensaje) {
        while (true) {
            try {
                System.out.println(mensaje);
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Error. Ingresa un número decimal válido (por ejemplo: 15.50)");
            }
        }
    }
}
