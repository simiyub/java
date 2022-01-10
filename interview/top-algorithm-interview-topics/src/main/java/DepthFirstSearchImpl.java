import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class DepthFirstSearchImpl implements DepthFirstSearch {


    public Graph createGraph(String[] airports, String[][] routes) {
        Graph graph = new Graph();
        Arrays.stream(airports).forEach(graph::addNode);
        Arrays.stream(routes[0]).forEach( name ->{
                List<String> airs = Arrays.stream(airports).filter(air -> Objects.equals(name, air)).collect(Collectors.toList());
                airs.forEach(air -> graph.addEdge(air,name));
        });
        return graph;
    }

    @Override
    public void search() {

    }
}
