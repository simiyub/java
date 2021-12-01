import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWaitingTimeTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void minimumWaitingTime() {
        int[] executionTimes=new int[]{3,2,1,2,6};
        assertEquals(17, new MinimumWaitingTimeImpl().minimumWaitingTime(executionTimes));
    }
}