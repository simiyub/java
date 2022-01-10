import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {
    DepthFirstSearchImpl depthFirstSearch;

    @BeforeEach
    void setUp() {

        String[] airports = new String[]{"PHX", "BKK", "OKC", "JFK", "LAX",
                "MEX","EZE","HEL", "LOS", "LAP", "LIM"};
        String[][] routes = new String[][]{
                new  String[]{"PHX","LAX"},
                new String[]{"PHX", "JFK"},
                new String[]{"JFK", "OKC"},
                new String[]{"JFK", "HEL"},
                new String[]{"JFK", "LOS"},
                new String[]{"MEX", "LAX"},
                new String[]{"MEX", "BKK"},
                new String[]{"MEX", "LIM"},
                new String[]{"MEX", "EZE"},
                new String[]{"LIM", "BKK"}
        };

        depthFirstSearch = new DepthFirstSearchImpl();
        depthFirstSearch.createGraph(airports,routes);
    }

    @Test
    void search1() {
        assertFalse(depthFirstSearch.search("PHX", "BKK"));

    }

    @Test
    void search2() {
        assertTrue(depthFirstSearch.search("MEX", "BKK"));

    }

    @Test
    void  testGraph(){
        assertNotNull(depthFirstSearch.getGraph());
    }
}