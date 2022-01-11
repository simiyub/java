import java.util.Arrays;

public interface GraphTraversal {

    boolean search(String origin, String destination);

   static Graph createGraph(String[] airports, String[][] routes) {
        Graph graph = new Graph();
        Arrays.stream(airports).forEach(graph::addNode);
        graph.getNodes().forEach( (nodeName, node) -> Arrays.stream(routes).forEach(route ->{
            if(route[0].equals(nodeName)) node.addAdjacentNode(route[1]);
            else  if(route[1].equals(nodeName)) node.addAdjacentNode(route[0]);
        }));
        return graph;
    }
}
