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
        assertDoesNotThrow(() -> engine.schedule(1));
    }

    @Test
    void cancel() {
        assertDoesNotThrow(() -> engine.cancel(1));
    }

    void deadlineHandler(Long deadline){
        System.out.println(deadline + "deadline reached");
    }

    @Test
    void poll() {
        assertDoesNotThrow(() -> engine.poll(1,this::deadlineHandler, 5));
    }

    @Test
    void size() {
        assertDoesNotThrow(() -> engine.size());
    }
}