package network;

import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class HttpClient {

    public URI exchange(String query) throws Exception{
        String https="";
        final URI NBP =
                URI.create(new StringBuilder(https)
                        .append("http://api.nbp.pl/api/exchangerates/rates/c/")
                        .append(query)
                        .append("/today/")
                        .toString());
        return NBP;
    }
    public String getNBPQuery(String query) throws Exception{
        java.net.http.HttpClient client = java.net.http.HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(exchange(query))
                .GET()
                .build();
        HttpResponse<String> response =
                client.send(request,HttpResponse.BodyHandlers.ofString());
        return response.body();
    }
}
