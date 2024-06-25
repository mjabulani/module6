package org.example;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class JSONPlaceholderFetcher {


    final HttpClient client = HttpClient.newBuilder().build();
    final String baseUri = "https://jsonplaceholder.typicode.com/posts/";

    public String getSinglePost(int id) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUri + id))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();

        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public String getAllPosts() {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUri))
                    .GET()
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();
        } catch (URISyntaxException | IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean addPost(String post) {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(new URI(baseUri))
                    .POST(HttpRequest.BodyPublishers.ofString(post))
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return String.valueOf(response.statusCode()).equals("201");

        } catch (IOException | InterruptedException | URISyntaxException e) {
            throw new RuntimeException(e);
        }
    }
}
