package utils;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class HttpCall <T extends Requirement> {

    public Optional<Requirement> entitledStarlingAccounts  (RequirementObjectMapper objectMapper, ConfigProperties configProperties) {
        Requirement response = null;
        try {

            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configProperties.getProperty("ENDPOINT")))
                    .setHeader("Authorization", "Bearer " + configProperties.getProperty("TOKEN"))
                    .build();

            response = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(objectMapper::readValue)
                    .get();
            System.out.println(response);
        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            return Optional.ofNullable(response);
        }

    }
}