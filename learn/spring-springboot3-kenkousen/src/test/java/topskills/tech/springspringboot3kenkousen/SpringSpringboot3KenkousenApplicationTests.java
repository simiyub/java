package topskills.tech.springspringboot3kenkousen;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Aspect
@SpringBootTest(webEnvironment =  SpringBootTest.WebEnvironment.RANDOM_PORT)
class SpringSpringboot3KenkousenApplicationTests {

	@Test
	void contextLoads(TestRestTemplate) {
	}

}
