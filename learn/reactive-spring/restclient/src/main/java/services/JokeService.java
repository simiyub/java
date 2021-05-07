package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
import services.json.JokeResponse;

@Service
public class JokeService {
    private final RestTemplate template;
    private final WebClient client;

    @Autowired
    public JokeService(RestTemplateBuilder builder){

        template = builder.build();
        client = null;
    }

    @Autowired
    public JokeService(WebClient.Builder builder){
        client = builder.baseUrl("http://api.icndb.com").build();
        template = null;
    }

    public Mono<String> getJokeAsync(String first, String last){
        return client.get()
                .uri(uriBuilder -> uriBuilder.path("/jokes/random")
                        .queryParam("limitTo", "[nerdy]")
                        .queryParam("firstName", first)
                        .queryParam("lastName", last)
                        .build())
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(JokeResponse.class)
                .map(jokeResponse -> jokeResponse.getValue().getJoke());
    }

    public String getJokeSync(String first, String last){
        String base = "http://api.icndb.com/jokes/random?limitTo=[nerdy]";
        String url = String.format("%s&firstName=%s&lastName=%s", base, first, last);
        JokeResponse response = template.getForObject(url, JokeResponse.class);
        if(response!=null){
            return response.getValue().getJoke();
        }
        return "No joke found";
    }
}
