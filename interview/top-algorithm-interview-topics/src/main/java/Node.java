import java.util.ArrayList;
import java.util.List;

public class Node {
    private String name;
    private List<String> adjacentNodes;

    public Node(String name) {
        this.name = name;
        adjacentNodes = new ArrayList<>();
    }


    public List<String> getAdjacentNodes() {
        return adjacentNodes;
    }

    public void addAdjacentNode(String adjacentNode) {
        this.adjacentNodes.add(adjacentNode);
    }
}
