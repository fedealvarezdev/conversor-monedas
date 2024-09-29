package org.example.conversor;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conversor {

    public Conversor(){
    }

    private CambioRecord obtenerCambio(Moneda moneda){
        try {
            String requestUrl = "https://v6.exchangerate-api.com/v6/<TU_API_TOKEN>/latest/" + moneda;

            HttpResponse<String> response;
            try (HttpClient client = HttpClient.newHttpClient()) {
                HttpRequest request = HttpRequest.newBuilder()
                        .uri(URI.create(requestUrl))
                        .build();

                response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());
            }

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .setPrettyPrinting()
                    .create();

            System.out.println(response.body());

            return gson.fromJson(response.body(), CambioRecord.class);

        } catch (IOException | InterruptedException e) {
            System.out.println("Ocurrio un error");
            throw new RuntimeException(e);
        }
    }

    public double convertirMondeda(Moneda moneda1, Moneda moneda2, double monto) {
        double cambio =  obtenerCambio(moneda1).conversion_rates().get(moneda2.toString());
        return monto * cambio;
    }
}