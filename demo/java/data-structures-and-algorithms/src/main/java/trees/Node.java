package trees;

class Node {


    Node left;
    Node right;
    char data;

    Node(char data) {
        this.data = data;
    }

    public Node(Node before, Node after, int value) {
        this.left = before;
        this.right = after;
        this.data = data;
    }

    public Node insert(char value) {
        Node inserted;
        if (value <= data) {
            if (left == null) {
                left = new Node(value);
                inserted = left;
            } else {
                inserted = left.insert(value);
            }


        } else {
            if (right == null) {
                right = new Node(value);
                inserted = right;
            } else {
                inserted = right.insert(value);
            }
        }
        return inserted;
    }

    public Node search(int value) {
        Node found;
        if (data == value) {
            found = this;
        } else if (value <= data) {
            if (left.data == value) {
                found = left;
            } else {
                found = left.search(value);
            }
        } else {
            if (right.data == value) {
                found = right;
            } else {
                found = right.search(value);
            }
        }
        return found;
    }

    void inOrderTraversal() {

        if (left != null) {
            left.inOrderTraversal();
        }
        System.out.println(data);
        if (right != null) {
            right.inOrderTraversal();
        }
    }

    void preOrderTraversal() {

        System.out.println(data);
        if (left != null) {
            left.preOrderTraversal();
        }
        if (right != null) {
            right.preOrderTraversal();
        }
    }

    void postOrderTraversal() {

        if (left != null) {
            left.postOrderTraversal();
        }
        if (right != null) {
            right.postOrderTraversal();
        }
        System.out.println(data);
    }




}
