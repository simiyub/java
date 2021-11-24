import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tournamentwinner.TournamentWinnerBasicImpl;

import static org.junit.jupiter.api.Assertions.*;

class TournamentWinnerTest {

    @BeforeEach
    void setUp() {
    }

    @Test
    void tournamentWinner1() {

        String expectedResult="winner";
        String[] matchOne = new String[]{"winner","loser" };
        String[][] matches=new String[][]{matchOne};
        int[] results = new int[]{1};
        assertEquals(expectedResult, new TournamentWinnerBasicImpl().tournamentWinner(matches,results));
 }

    @Test
    void tournamentWinner2() {

        String[][] matches2=new String[][]{new String[]{"team1","team2" }, new String[]{"team1","team3" }};
        int[] results2 = new int[]{1,1};
        String expectedResult2="team1";
        assertEquals(expectedResult2, new TournamentWinnerBasicImpl().tournamentWinner(matches2,results2));

       }

    @Test
    void tournamentWinnerTest3() {

        String[][] matches3=new String[][]{new String[]{"team2","team1" }, new String[]{"team3","team2" }};
        int[] results3 = new int[]{1,0};
        String expectedResult3="team2";
        assertEquals(expectedResult3, new TournamentWinnerBasicImpl().tournamentWinner(matches3,results3));
    }
}