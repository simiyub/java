

/**
 * A linked list organizes items sequentially,
 * with each item storing a pointer to the next one.
 * An item in a linked list is called a node.
 * The first node is called the head.
 * The last node is called the tail.
 *          Worst Case
 * space	O(n)O(n)
 * prepend	O(1)O(1)
 * append	O(1)O(1)
 * lookup	O(n)O(n)
 * insert	O(n)O(n)
 * delete	O(n)O(n)
 * */
public class LinkedListDemo {
    private static Node head;

    private static class Node {

        Node before;
        Node after;
        Object data;
        Node(Object data){
            this.data = data;
        }

        public Node(Node before, Node after, Object data) {
            this.before = before;
            this.after = after;
            this.data = data;
        }


    }


    public int getSize() {
        return size;
    }

    private int size = 0;

    public Node find(Object data){
        Node current = head;
        while(current!=null){
            if(current.data == data){
                return current;
            }
            current = current.after;
        }
        return null;
    }

    public  void append (Object data){

        if (head == null){
            head = new Node(data);
            size +=1;
            return;
        }
        else{
            Node current = head;
            Node newNode = new Node(data);
            while(current!=null) {
                if(current.after == null){
                    current.after = newNode;
                    newNode.before = current;
                    size +=1;
                    break;
                }
                else{
                    current = current.after;
                }
            }
        }

        return;

    }

    public int[] data(){

        int[] arr = new int[size];
        Node current = head;
        for(int i=0;i<size;i++){
            arr[i] = (int) current.data;
            current = current.after;
        }
        return arr;
    }

    public Node prepend(Object data){
        Node newHead = new Node(data);
        head.before = newHead;
        newHead.after = head;
        head = newHead;
        return head;
    }

    public boolean deleteWithValue(Object value) {
        if (head == null) {
            System.out.println("empty list.");
        } else {

            if (head.data == value) {
                head = head.after;
                head.before = null;
                return false;
            }

            Node current = head;

            while (current.after != null) {

                if (current.data == value) {
                    current.before.after = current.after;
                    current.after.before = current.before;
                    return true;
                }

                current = current.after;

            }
        }
        return false;

    }

    @Override
    public String toString() {

        return data().toString();
    }
}
