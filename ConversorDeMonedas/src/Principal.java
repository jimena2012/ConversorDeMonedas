import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.io.IOException;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {

        while(true) {
            Scanner numeros = new Scanner(System.in);
            System.out.println("Sea bienvenido al conversor de monedas:");
            System.out.println("1) Dólar -> Peso argentino");
            System.out.println("2) Peso argentino -> Dólar");
            System.out.println("3) Dólar -> Real brasileño");
            System.out.println("4) Real brasileño -> Dólar");
            System.out.println("5) Dólar -> Peso colombiano");
            System.out.println("6) Peso colombiano -> Dólar");
            System.out.println("7) Salir");
            System.out.println("Elija una de las opciones:");

            var opciones = numeros.nextLine();
            Conversion conversion = new Conversion();
            try {
                int numero = Integer.parseInt(opciones);
                if (numero >= 1 && numero <= 6) {
                    String direccion = "https://v6.exchangerate-api.com/v6/29b6d99b5300a9d0d8049d57/pair/" + conversion.getConversion(numero);
                    HttpClient client = HttpClient.newHttpClient();
                    HttpRequest request = HttpRequest.newBuilder()
                            .uri(URI.create(direccion))
                            .build();

                    HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
                    String json = response.body();

                    Gson gson = new GsonBuilder()
                            .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                            .setPrettyPrinting()
                            .create();

                    TasaDeCambio miTasa = gson.fromJson(json, TasaDeCambio.class);
                    Scanner cantidad = new Scanner(System.in);
                    System.out.println("Ingrese la cantidad a convertir:");
                    Double tasaActual = miTasa.getConversionRate();
                    var cantidadDeDinero = cantidad.nextLine();
                    try {
                        Double dineroFinal = Double.valueOf(cantidadDeDinero);
                        System.out.println("El cambio es de : " + tasaActual * dineroFinal);
                    }catch (NumberFormatException e) {
                        System.out.println("Ocurrio un error, no es un numero");
                        System.out.println(e.getMessage());
                    }

                } else if (numero == 7) {
                    break;
                } else {
                    System.out.println("Este numero no esta dentro de las opciones");
                }
            } catch (NumberFormatException e) {
                System.out.println("Ocurrio un error, no es un numero");
                System.out.println(e.getMessage());
            }
        }
    }
}
