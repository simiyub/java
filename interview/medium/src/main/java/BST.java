/**
 * BST implementation with O(n) T and O(n) S in worst case
 * */
public class BST implements BSTContract {
    private final int value;
    private BST left;
    private BST right;

    public BST(int value) {
        this.value =value;
    }

    @Override
    public BST insert(int value) {
        if(value<this.value) {
            if(this.left == null) {
                this.left = new BST(value);
                return this.left;
            }
            return this.left.insert(value);
        }
        else if(value>this.value) {
            if(this.right == null) {
                this.right = new BST(value);
                return this.right;
            }
            return this.right.insert(value);
        }
        return this;
    }

    @Override
    public BST remove(int value) {
        return null;
    }

    @Override
    public boolean contains(int value) {
        if(this.value == value) return true;

        if(value<this.value){
            if (this.left==null) return false;
            else return this.left.contains(value);
        }
        else {
            if (this.right==null) return false;
            else return this.right.contains(value);
        }
    }

}
