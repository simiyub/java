/**
 * O(dw1 + dw2) T and O(dw1 + dw2) S
 * We traverse the tree tracking the depth and once we've identified
 * the depth of both trees, we compare and  move the deepest of the two to
 * match the depth of the other descendant. We then walk through the
 * ancestors going back up the hierarchy until we have a matching common ancestor and return it.
 * */
public class YoungestCommonAncestorImpl implements YoungestCommonAncestor{
    @Override
    public AncestralTree getYoungestCommonAncestor(AncestralTree topAncestor, AncestralTree one, AncestralTree two) {
        boolean descendantOneNotFound = true;
        boolean descendantTwoNotFound = true;
        int descendantOneDepth = 0;
        int descendantTwoDepth = 0;
        AncestralTree currentAncestorOne = one;
        AncestralTree currentAncestorTwo = two;
        while (descendantOneNotFound || descendantTwoNotFound){

            if(currentAncestorOne== topAncestor) descendantOneNotFound=false;
            if(currentAncestorTwo==topAncestor) descendantTwoNotFound = false;

            if (descendantOneNotFound) {
                currentAncestorOne = currentAncestorOne.ancestor;
                descendantOneDepth++;
            }
            if (descendantTwoNotFound) {
                currentAncestorTwo = currentAncestorTwo.ancestor;
                descendantTwoDepth++;
            }

        }

        AncestralTree deepest = descendantOneDepth > descendantTwoDepth ? one : two;
        if(deepest == one){
            currentAncestorOne = findMatchingAncestor(one,descendantOneDepth-descendantTwoDepth);
            currentAncestorTwo = two;
        }
        if(deepest == two) {
            currentAncestorTwo = findMatchingAncestor(two,descendantTwoDepth-descendantOneDepth);
            currentAncestorOne = one;
        }

        while(currentAncestorOne!=currentAncestorTwo){
            currentAncestorOne = currentAncestorOne.ancestor;
            currentAncestorTwo = currentAncestorTwo.ancestor;
        }
        return currentAncestorTwo;
    }

    private AncestralTree findMatchingAncestor(AncestralTree ancestralTree, int levelRequired) {
        while (levelRequired!=0) {
            ancestralTree = ancestralTree.ancestor;
            levelRequired--;
        }
        return ancestralTree;
    }
}
