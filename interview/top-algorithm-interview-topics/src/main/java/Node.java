import java.util.ArrayList;
import java.util.List;

public class Node {
    private final String name;
    private final List<String> adjacentNodes;

    public Node(String name) {
        this.name = name;
        adjacentNodes = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addAdjacentNode(String adjacentNode) {
        this.adjacentNodes.add(adjacentNode);
    }
}
