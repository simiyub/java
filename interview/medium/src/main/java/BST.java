/**
 * BST implementation with O(n) T and O(n) S in worst case
 * */
public class BST implements BSTContract {
    private int value;
    private BST left;
    private BST right;

    @Override
    public BST insert(int value) {
        this.value = value;
        return this;
    }

    @Override
    public BST remove(int value) {
        return null;
    }

    @Override
    public boolean contains(int value) {
        if(this.value == value) return true;
        else if (this.left.contains(value)) return true;
        else return this.right.contains(value);
    }

    public int getValue() {
        return value;
    }

    public BST getLeft() {
        return left;
    }

    public BST getRight() {
        return right;
    }
}
