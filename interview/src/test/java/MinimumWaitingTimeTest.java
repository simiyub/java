import minimumwaitingtime.MinimumWaitingTimeImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWaitingTimeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minimumWaitingTime() {
        int[] executionTimes=new int[]{1, 1, 1, 4, 5, 6, 8, 1, 1, 2, 1};
        assertEquals(81, new MinimumWaitingTimeImpl().minimumWaitingTime(executionTimes));
    }
}