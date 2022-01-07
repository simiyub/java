/**
 * O(dw1 + dw2) T and O(dw1 + dw2) S
 * We traverse the tree tracking the depth and once we've identified
 * the depth of both trees, we compare and  move the deepest of the two to
 * match the depth of the other descendant. We then walk through the
 * ancestors going back up the hierarchy until we have a matching common ancestor and return it.
 * */
public class YoungestCommonAncestorImpl implements YoungestCommonAncestor{
    @Override
    public AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo) {
        return null;
    }
}
