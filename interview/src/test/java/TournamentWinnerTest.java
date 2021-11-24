import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TournamentWinnerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void tournamentWinner() {

        String expectedResult="winner";
        String[] matchOne = new String[]{"winner","loser" };
        String[][] matches=new String[][]{matchOne};
        int[] results = new int[]{1};
        assertEquals(expectedResult, new TournamentWinnerBasicImpl().tournamentWinner(matches,results));
    }
}