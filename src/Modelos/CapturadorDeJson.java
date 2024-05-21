package Modelos;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class CapturadorDeJson {

    /*
    ESTA CLASE OBTIENE UN JSON Y LO TRANSFORMA A FORMATO STRING
     */

    String direccion;

    public String jsonDivisaComoString(String divisa) throws IOException, InterruptedException {

        direccion = "https://v6.exchangerate-api.com/v6/2922f55859f0176660adb885/latest/"
                + divisa;

        //CONSTRUYENDO EL HTTP CLIENT:

        HttpClient client = HttpClient.newHttpClient();

        //CONSTRUYENDO EL HTTP REQUEST:

        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(direccion))
                .GET()
                .build();

        //CONSTRUYENDO EL HTTP RESPONSE:

        HttpResponse<String> response = client
                .send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();

    }

}
