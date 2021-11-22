
import java.util.ArrayDeque;
import java.util.Queue;

public class BinaryTree<T> {
    
    private int nodeCount;
    private Node root = null;

    private class Node {
        private  final Node left;
        private  final Node right;
        private  final T element;

        public Node(T element){
            this.element = element;
            this.left = null;
            this.right = null;
        }

        public Node(Node left, Node right, T element){
            this.element = element;
            this.left = left;
            this.right = right;
        }

    }


    private void printBreadthFirstSearch(Node node) {
        Queue<Node> queue = new ArrayDeque();
        queue.add(node);

        while(!queue.isEmpty()){
            Node current = queue.poll();
            System.out.println("current element is"+current.element);

            if(current.left!=null){
                queue.add(current.left);
            }

            if(current.right!=null){
              queue.add(current.right);
            }
        }

    }

    private void printDepthFirstSearchPreOrder(Node node) {

        if (node != null) {
            System.out.println("" + node.element);
            printDepthFirstSearchPreOrder(node.left);
            printDepthFirstSearchPreOrder(node.right);
        }
    }

    private void printDepthFirstSearchInOrder(Node node){
        if (node!=null){
            printDepthFirstSearchInOrder(node.left);
            System.out.println(""+node.element);
            printDepthFirstSearchInOrder(node.right);
        }
    }

    private void printDepthFirstSearchPostOrder(Node node){
        if(node!=null){
            printDepthFirstSearchPostOrder(node.left);
            printDepthFirstSearchPostOrder(node.right);
            System.out.println(""+node.element);
        }
    }
}
