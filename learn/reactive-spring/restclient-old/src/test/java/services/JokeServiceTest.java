package services;

import org.junit.jupiter.api.Test;
import org.junit.platform.commons.logging.Logger;
import org.junit.platform.commons.logging.LoggerFactory;
import org.mockito.internal.util.Supplier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class JokeServiceTest {
    private final Logger logger = LoggerFactory.getLogger(JokeServiceTest.class);

    @Test
    void getJokeSync(@Autowired JokeService service) {
        String joke = service.getJokeSync("Craig", "Walls");
        logger.info(joke);
        assertTrue(joke.contains("Craig") || joke.contains("Walls"));
    }
}