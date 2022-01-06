/**
 * O(dw1 + dw2) T and O(dw1 + dw2) S
 * We traverse the tree checking if the descendants are the current tree we are looking for
 * We store the ancestor as we walk down the tree.
 * When we find the trees we are interested in,
 * we look back comparing the two stores of ancestors we have and
 * determine the first common ancestor from where we found the descendants.
 * This will be the youngest common ancestor.
 * */
public class YoungestCommonAncestorImpl implements YoungestCommonAncestor{
    @Override
    public AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        return null;
    }
}
