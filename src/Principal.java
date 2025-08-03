import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            mostrarMenu();
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpia buffer

            switch (opcion) {
                case 1 -> ConversionHandler.convertir("USD", "ARS");
                case 2 -> ConversionHandler.convertir("ARS", "USD");
                case 3 -> ConversionHandler.convertir("USD", "BRL");
                case 4 -> ConversionHandler.convertir("BRL", "USD");
                case 5 -> ConversionHandler.convertir("USD", "COP");
                case 6 -> ConversionHandler.convertir("COP", "USD");
                case 7 -> System.out.println("Gracias por usar el conversor. ¡Hasta luego!");
                default -> System.out.println("Opción no válida.");
            }

        } while (opcion != 7);
    }

    public static void mostrarMenu() {
        System.out.println("**********************************************");
        System.out.println("Sea bienvenido/a al Conversor de Moneda =]");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileño");
        System.out.println("4) Real brasileño =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Salir");
        System.out.println("Elija una opción válida:");
        System.out.println("**********************************************");
    }

}
