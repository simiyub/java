package trees;

public class BinaryTree{
    Node head;

   // @Override
    public Node insert(char value) {
        if (head == null){
            head = new Node(value);
            return head;
        }
        return head.insert(value);
    }

    //@Override
    public Node search(char value) {
        return head.search(value);
    }

    //@Override
    public void traverse() {
        head.inOrderTraversal();
    }

    public void traversePreOrder() {
        head.inOrderTraversal();
    }

    public void traversePostOrder() {
        head.inOrderTraversal();
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        String balloon = "BALLOON";
        for(int i=0; i<balloon.length(); i++){
            tree.insert(balloon.charAt(i));
        }
        tree.traverse();
    }
}
