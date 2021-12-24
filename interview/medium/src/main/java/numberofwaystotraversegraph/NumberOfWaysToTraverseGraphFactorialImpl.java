package numberofwaystotraversegraph;

/**
 * O(n+m) T and O(1) S as we use the factorial and no more space required.
 *
 * How it works
 * ------------
 * We use factorial to determine the number of permutations available to get
 * to the end end of the graph
 * */
public class NumberOfWaysToTraverseGraphFactorialImpl implements NumberOfWaysToTraverseGraph {
    @Override
    public int count(int width, int height) {
        return factorial(Math.abs(height-1 + width-1))/
                (factorial((height-1)) * factorial((width-1)));
    }

    private int factorial(int n) {
        if(n>1){
            return n*factorial(n-1);
        }
        return 1;
    }
}
