package breadthfirstsearch;

import java.util.ArrayList;
import java.util.List;

/**
 * This function takes in a node at the top of a graph
 * and return an array of the names of the nodes in the graph after traversing
 * theg
 * **/
public interface BreadthFirstSearch {
    List<String> search(Node nod);

    class Node{

        public String name;
        public List<Node> children = new ArrayList<>();

    public Node(String name) {
        this.name = name;

    }
    }

}
