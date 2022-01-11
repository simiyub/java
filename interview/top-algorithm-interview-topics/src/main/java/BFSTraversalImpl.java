import java.util.*;

public class BFSTraversalImpl implements GraphTraversal {
    private Graph graph;

    public void createGraph(String[] airports, String[][] routes) {
        graph = new Graph();
        Arrays.stream(airports).forEach(graph::addNode);
        graph.getNodes().forEach( (nodeName, node) -> Arrays.stream(routes).forEach(route ->{
            if(route[0].equals(nodeName)) node.addAdjacentNode(route[1]);
            else  if(route[1].equals(nodeName)) node.addAdjacentNode(route[0]);
        }));
    }

    @Override
    public boolean search(String origin, String destination) {
        Queue<String> queue = new LinkedList<>();
        List<String> routes = new ArrayList<>();
        queue.add(origin);
        Set<String> seen = new HashSet<>();
        while (!queue.isEmpty()){
            String currentNodeName = queue.remove();
            if(!seen.contains(currentNodeName)){
                seen.add(currentNodeName);
                Node currentNode = graph.getNodes().get(currentNodeName);

                currentNode.getAdjacentNodes().forEach( currentDestination ->{
                    queue.add(currentDestination);
                    if(currentNodeName .equals(origin) && currentDestination.equals(destination)){
                        System.out.printf("found %s from %s ",destination,currentNodeName);
                        routes.add(currentNodeName);
                    }
                });

            }
        }
        return !routes.isEmpty();

    }

    public Graph getGraph() {
        return graph;
    }
}
