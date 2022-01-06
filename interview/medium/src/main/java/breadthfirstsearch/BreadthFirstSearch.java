package breadthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * This function will take in a node at the top of a graph
 * and return an array of the names of the nodes in the graph
 * **/
public interface BreadthFirstSearch {
    List<String> search(Node nod);

    class Node{

        String name;
        List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;

    }}


}
