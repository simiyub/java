import java.util.*;

public class BFSTraversalImpl implements GraphTraversal {
    private final Graph graph;

    public BFSTraversalImpl(Graph graph) {
        this.graph = graph;
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

                graph.getNodes().get(currentNodeName).getAdjacentNodes().forEach( currentDestination ->{
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
}
