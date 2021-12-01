import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TandemBicycleTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void speed() {
        int[] teamA = new int[]{5,5,3,9,2};
        int[] teamB = new int[]{3, 6, 7, 2, 1};
        assertEquals(32, new TandemBicycleImpl().speed(teamA, teamB, true));
    }
}