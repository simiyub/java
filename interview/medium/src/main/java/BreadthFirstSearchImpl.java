import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * O(v+e) T O(v) S
 * How it works
 * ------------
 * By adding the names on a queue
 * we can then populate a new array of the names we pop off the queue in FIFO.
 * */

public class BreadthFirstSearchImpl implements BreadthFirstSearch{
    @Override
    public List<String> search(Node node) {

        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        Node currentNode;
        List<String> names = new ArrayList<>();
        while (!queue.isEmpty()){
            currentNode = queue.poll();
            names.add(currentNode.name);
            queue.addAll(currentNode.children);
        }
        return names;
    }
}
