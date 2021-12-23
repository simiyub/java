import levenshteindistance.LevenshteinDistanceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LevenshteinDistanceTest {
    
    @Test
    void testLevenshteinDistance(){
        int expected = 2;

        String toMatch = "soccer";
        String toEdit ="socca";
        assertEquals(expected, new LevenshteinDistanceImpl().levenshteinDistance(toEdit, toMatch));
        
    }

}