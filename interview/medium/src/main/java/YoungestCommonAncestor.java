/**
 * This function takes in three instances of ancestral trees representing
 * the most senior of the trees and two descendants. It returns the
 * youngest common ancestor of the two descendants. Effectively, the ancestor closest to
 * the two descendants. An ancestral tree is considered to be it's own
 * ancestor.
 * */
public interface YoungestCommonAncestor {
    AncestralTree getYoungestCommonAncestor(
            AncestralTree topAncestor, AncestralTree descendantOne, AncestralTree descendantTwo);

    class AncestralTree {
        public char name;
        public AncestralTree ancestor;

        AncestralTree(char name) {
            this.name = name;
            this.ancestor = null;
        }

        void addAsAncestor(AncestralTree[] descendants) {
            for (AncestralTree descendant : descendants) {
                descendant.ancestor = this;
            }
        }
    }

}
