import java.util.*;
import java.util.stream.Collectors;

public class DepthFirstSearchImpl implements DepthFirstSearch {
    private Graph graph;

    public Graph createGraph(String[] airports, String[][] routes) {
        graph = new Graph();
        Arrays.stream(airports).forEach(graph::addNode);
        graph.getNodes().forEach( (nodeName, node) ->{
            Arrays.stream(routes).forEach(route ->{
                if(route[0].equals(nodeName)) node.addAdjacentNode(route[1]);
                else  if(route[1].equals(nodeName)) node.addAdjacentNode(route[0]);
            });
        });
        return graph;
    }

    @Override
    public boolean search(String origin, String destination) {
        Queue<String> queue = new LinkedList<>();
        queue.add(origin);
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()){
            String currentNodeName = queue.remove();
            if(!seen.contains(currentNodeName)){
                seen.add(currentNodeName);
                Node currentNode = graph.getNodes().get(currentNodeName);
                if(currentNode.equals(destination)) return true;
                currentNode.getAdjacentNodes().stream().forEach(queue::add);
            }
        }
        return false;

    }

    public Graph getGraph() {
        return graph;
    }
}
