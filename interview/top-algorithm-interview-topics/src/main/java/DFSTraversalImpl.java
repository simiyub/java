import java.util.List;

public class DFSTraversalImpl  implements GraphTraversal{
    Graph graph;
    public DFSTraversalImpl(Graph graph) {
        this.graph = graph;
    }
    @Override
    public boolean search(String origin, String destination) {
       return search(origin, origin, destination);
    }
    public boolean search(String origin, String currentOrigin, String destination) {
        Node currentNode = graph.getNodes().get(currentOrigin);
        List<String> destinations = currentNode.getAdjacentNodes();
        if(destinations.contains(destination) && currentNode.getName().equals(origin)){
            System.out.printf("found %s from %s",destination,currentOrigin);
            return true;
        }
        destinations.forEach(d -> search(currentNode.getName(),currentOrigin, d));

        return false;

    }

}
