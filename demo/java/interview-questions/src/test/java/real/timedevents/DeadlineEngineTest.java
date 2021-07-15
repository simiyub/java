package real.timedevents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineEngineTest {
    private DeadlineEngine engine;

    @BeforeEach
    void setUp() {
        engine = new DeadlineEngineImpl();
    }

    @Test
    void schedule() {
        long deadline = 1;
        assertDoesNotThrow(() -> engine.schedule(deadline));
    }


    @Test
    void cancel() {
        assertTrue(engine.cancel(1));
    }

    void deadlineHandler(Long deadline){
        System.out.println(deadline + "deadline reached");
    }

    @Test
    void poll() {
        long id = engine.schedule(1);
        int result = engine.poll(id,this::deadlineHandler, 5);
        assertEquals(1,result);
    }

    @Test
    void size() {
        long deadline = 2;
        engine.schedule(deadline);
        assertEquals(1,engine.size());
    }
}