/**
 * BST implementation with O(n) T and O(n) S in worst case
 * */
public class BST implements BSTContract {
    private int value;
    private BST left;
    private BST right;

    public BST(int value) {
        this.value =value;
    }

    /**
     * inserts the value to the left if it is less than the value of this BST
     * or to the right of this BST if it is greater than the value of this BST
     * */
    @Override
    public BST insert(int value) {
        if(value<this.value) {
            if(this.left == null) {
                this.left = new BST(value);
            }
           else left.insert(value);
        }
        else {
            if(this.right == null) {
                this.right = new BST(value);
            }
            else this.right.insert(value);
        }
        return this;
    }

    /**
     * Checks if this tree has the given value and if so, removes and repoints its
     * children accordingly
     * */

    public BST remove(int value) {
        remove(null, value);
        return  this;
    }
        public void remove(BST parent, int value) {

            if (left != null && value < this.value) left.remove(this, value);
            else if (right != null && value > this.value) right.remove(this, value);
            else {
                if(left!=null && right!=null){
                    this.value = right.getLeastValue();
                    right.remove(this, this.value);
                }
                else if(parent == null) {
                    if(left!=null){
                        this.value = left.value;
                        right =left.right;
                        left = left.left;
                    }
                    else if(right!=null){
                        this.value = right.value;
                        left =right.left;
                        right = right.right;
                    }
                    else{
                        System.out.println("cannot delete root.");
                    }
                } else if (parent.left == this) {
                    parent.left = left != null ? left : right;

                }else if(parent.right == this){
                    parent.right = left !=null ? left : right;

                }
            }
        }

    private int getLeastValue() {
        if(left == null) return  this.value;
        else return left.getLeastValue();
    }


    /**
     * Recursively checks if this BST or it's children contain the given value
     * */
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
