package services;

import org.junit.jupiter.api.Test;
import org.mockito.internal.util.Supplier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = {services.JokeService.class})
class JokeServiceTest {
    private final Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Autowired
    private JokeService jokeService;

    @Test
    void getJokeSync() {
        String joke = jokeService.getJokeSync("Craig", "Walls");
        logger.info(joke);
        assertTrue(joke.contains("Craig") || joke.contains("Walls"));
    }

    @Test
    public void getJokeAsync() {
        String joke = jokeService.getJokeAsync("Craig", "Walls")
                .block(Duration.ofSeconds(2));
        logger.info(joke);
        assertTrue(joke.contains("Craig") || joke.contains("Walls"));
    }

}