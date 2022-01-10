import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepthFirstSearchTest {

    @Test
    void search() {

    }

    @Test
    void  testGraph(){

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
        Graph graph = new DepthFirstSearchImpl().createGraph(airports,routes);
        System.out.println(graph.getNodes());
    }
}