import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphTraversalTest {
    String[] airports;
    String[][] routes;

    @BeforeEach
    void setUp() {

        airports = new String[]{"PHX", "BKK", "OKC", "JFK", "LAX",
                "MEX","EZE","HEL", "LOS", "LAP", "LIM"};
        routes = new String[][]{
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
    }

    private void runTests(GraphTraversal impl){
        assertFalse(impl.search("PHX", "BKK"));
        assertTrue(impl.search("MEX", "BKK"));
    }

    @Test
    void dfsImplTest() {
        DFSTraversalImpl impl = new DFSTraversalImpl(GraphTraversal.createGraph(airports,routes));
        runTests(impl);
    }

    @Test
    void bfsImplTest() {
        BFSTraversalImpl impl = new BFSTraversalImpl(GraphTraversal.createGraph(airports,routes));
        runTests(impl);
    }

    @Test
    void  testGraph(){
        assertNotNull(GraphTraversal.createGraph(airports,routes));
    }
}