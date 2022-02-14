package accounts;

import utils.ConfigProperties;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Optional;

public class StarlingAcccounts {

    public Optional<Accounts> entitledStarlingAccounts() {
        Accounts accounts = null;
        try {

            ConfigProperties configProperties = new ConfigProperties("account.properties");
            AccountObjectMapper accountObjectMapper = new AccountObjectMapper();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(configProperties.getProperty("ENDPOINT")))
                    .setHeader("Authorization", "Bearer " + configProperties.getProperty("TOKEN"))
                    .build();

            accounts = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                    .thenApply(HttpResponse::body)
                    .thenApply(accountObjectMapper::readValue)
                    .get();
            System.out.println(accounts);
        } catch (Exception exception) {
            exception.printStackTrace();

        } finally {
            return Optional.ofNullable(accounts);
        }

    }
}