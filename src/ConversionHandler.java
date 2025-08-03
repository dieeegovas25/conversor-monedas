import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;

public class ConversionHandler {
    private static final String API_KEY = "8040579e79eadc50d634afc2"; // Reemplaza con tu API Key real
    private static final String BASE_URL = "https://v6.exchangerate-api.com/v6/" + API_KEY + "/latest/";

    public static void convertir(String monedaBase, String monedaDestino) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese la cantidad en " + monedaBase + ": ");
        double cantidad = scanner.nextDouble();

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(BASE_URL + monedaBase))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            JsonObject jsonObject = JsonParser.parseString(response.body()).getAsJsonObject();
            JsonObject conversionRates = jsonObject.getAsJsonObject("conversion_rates");

            if (!conversionRates.has(monedaDestino)) {
                System.out.println("Error: moneda no encontrada.");
                return;
            }

            double tasa = conversionRates.get(monedaDestino).getAsDouble();
            double resultado = cantidad * tasa;

            System.out.printf(">> %.2f %s equivalen a %.2f %s%n", cantidad, monedaBase, resultado, monedaDestino);

        } catch (IOException | InterruptedException e) {
            System.out.println("Error al obtener datos de la API: " + e.getMessage());
        }
    }
}
