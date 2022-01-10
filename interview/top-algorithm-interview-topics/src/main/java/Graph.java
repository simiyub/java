import java.util.HashMap;
import java.util.Map;

public class Graph {
    private final Map<String, Node> nodes = new HashMap<>();

    public void addNode(String name){
        this.nodes.put(name, new Node(name));
    }
    public void addEdge(String nodeName,  String adjacentNodeName){
        nodes.get(nodeName).addAdjacentNode(adjacentNodeName);
        addNode(adjacentNodeName);
        nodes.get(adjacentNodeName).addAdjacentNode(nodeName);
    }

    public Map<String, Node> getNodes() {
        return nodes;
    }
}
