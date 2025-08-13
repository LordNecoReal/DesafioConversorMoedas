package org.example;

import com.google.gson.Gson;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ApiCambio {

    private String exchangeApiKey = "4644324c1e7442cfe65f9211";

    public ApiCambio() {
        // Construtor padrão
    }

    // O método agora retorna um objeto TaxaCambio
    public TaxaCambio consumirApi() {
        System.out.println("Consumindo a API de câmbio com a chave: " + this.exchangeApiKey);

        String url = "https://v6.exchangerate-api.com/v6/" + this.exchangeApiKey + "/latest/USD";

        try {
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .GET()
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            if (response.statusCode() == 200) {
                Gson gson = new Gson();
                return gson.fromJson(response.body(), TaxaCambio.class);
            } else {
                System.out.println("Erro na requisição. Status: " + response.statusCode());
                System.out.println("Corpo da resposta: " + response.body());
                return null;
            }

        } catch (IOException | InterruptedException e) {
            System.err.println("Ocorreu um erro ao consumir a API: " + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
}