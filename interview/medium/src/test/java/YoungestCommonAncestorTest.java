import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class YoungestCommonAncestorTest {

    @Test
    void getYoungestCommonAncestorTest() {
        YoungestCommonAncestor.AncestralTree b = new YoungestCommonAncestor.AncestralTree('B');
        YoungestCommonAncestor.AncestralTree a = new YoungestCommonAncestor.AncestralTree('A');
        YoungestCommonAncestor.AncestralTree i = new YoungestCommonAncestor.AncestralTree('I');
        YoungestCommonAncestor.AncestralTree h = new YoungestCommonAncestor.AncestralTree('H');
        YoungestCommonAncestor.AncestralTree d = new YoungestCommonAncestor.AncestralTree('D');

        d.addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{h,i});
        YoungestCommonAncestor.AncestralTree e = new YoungestCommonAncestor.AncestralTree('E');
        b.addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{d,e});

        YoungestCommonAncestor.AncestralTree f = new YoungestCommonAncestor.AncestralTree('F');
        YoungestCommonAncestor.AncestralTree g = new YoungestCommonAncestor.AncestralTree('G');
        YoungestCommonAncestor.AncestralTree c = new YoungestCommonAncestor.AncestralTree('C');
        c.addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{f,g});

        a.addAsAncestor(new YoungestCommonAncestor.AncestralTree[]{b,c});

        YoungestCommonAncestor.AncestralTree descendant1 = e;
        YoungestCommonAncestor.AncestralTree descendant2 = i;
        YoungestCommonAncestor.AncestralTree topAncestor = a;
        YoungestCommonAncestor.AncestralTree expected = b;
        assertEquals(expected,new YoungestCommonAncestorImpl().getYoungestCommonAncestor(topAncestor, descendant1, descendant2));
    }



}