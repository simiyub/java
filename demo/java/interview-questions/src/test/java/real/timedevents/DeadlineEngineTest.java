package real.timedevents;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

class DeadlineEngineTest {
    private DeadlineEngine engine;
    private List<Long> polled = new ArrayList<>();

    @BeforeEach
    void setUp() {
        engine = new DeadlineEngineImpl();
        polled = new ArrayList<>();
    }

    @Test
    void schedule() {
        long deadline = 1;
        assertDoesNotThrow(() -> engine.schedule(deadline));
    }


    @Test
    void cancel() {
        long deadline = 1;
        long id = engine.schedule(deadline);
        assertTrue(engine.cancel(id));
    }

    void deadlineHandler(Long deadline){
       // System.out.println(deadline+" processed.");
        polled.add(deadline);
    }

    @Test
    void poll() {
        Random random = new Random();
            long[] array = random.longs(10, 0, Instant.now().minusSeconds(1000).toEpochMilli())
                    .toArray();
            int count =0;
        for (long l : array) {
            engine.schedule(l);
            count ++;
        }
            System.out.println("scheduled " + count);

            int maxPoll = 1000000;
            int result = engine.poll(Instant.now().toEpochMilli(), this::deadlineHandler, maxPoll);
            System.out.println("polled " + polled.size());
            int expected = Math.min(count, maxPoll);
            assertEquals(expected,result);
    }

    @Test
    void pollHighVolume() {
        Random random = new Random();
        int[] deadlinesToTest = {100, 1000, 10_000, 100_000, 1_000_000};
        for(Integer integer:deadlinesToTest) {
            int countOfDeadlines = integer;
            long[] array = random.longs(countOfDeadlines, 0, Instant.now().minusSeconds(1000).toEpochMilli())
                    .toArray();
            long count = 0;
            for (long l:array) {
                engine.schedule(l);
                count ++;
            }
            System.out.println("scheduled " + count);

            int maxPoll = 10_000_000;
           polled.clear();
            Instant start = Instant.now();
            int result = engine.poll(Instant.now().toEpochMilli(), this::deadlineHandler, maxPoll);
            System.out.println("polled " + result);
            System.out.println("time:" + Duration.between(start, Instant.now()).toMillis());
        }

    }
    @Test
    void size() {
        long deadline = 2;
        engine.schedule(deadline);
        assertEquals(1,engine.size());
    }
}