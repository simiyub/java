package levenshteindistance;

/**
 * O(nm) T O(nm) S because we need to iterate through the two strings to determine the
 * number of edits required to match them up. The time required is the product of the
 * length of the two arrays. The space required is similarly the product of the two.
 *
 * How it works
 * ------------
 * We compare the characters in the same index location of the two strings and do the following:
 * If the characters in the index match, then we copy over the number of edits previously stored
 * in our combined array as we do not need to make an additional edit.
 * If they are different, then we take the previous value from the combined  array and add an extra edit.
 * When we are finished, we obtain the last value in our combined array
 * and that consists of the total number of edits required to match the two strings.
 * */
public class LevenshteinDistanceImpl implements LevenshteinDistance{

    @Override
    public int levenshteinDistance(String string1, String string2) {
        int[][] combined = new int[string1.length()+1][string2.length()+1];
        for(int i=0;i<combined[0].length;i++) combined[0][i] = i;
        for(int i=0;i<combined.length;i++) combined[i][0] = i;

        for(int row=1;row<=string1.length();row++){

            for (int col=1;col<=string2.length();col++){

                if(string1.charAt(row-1) == string2.charAt(col-1)) combined[row][col] = combined[row-1][col-1];
                else combined[row][col] = Math.min(
                        Math.min(combined[row-1][col-1],combined[row-1][col]),
                        combined[row][col-1]) +1;
            }
        }
        return combined[string1.length()][string2.length()];
    }
}
