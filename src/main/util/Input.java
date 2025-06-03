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
}
