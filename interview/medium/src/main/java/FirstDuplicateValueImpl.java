/***
 * O(n) T and O(1) S because we iterate through the array once and do not require additional
 * space as we use the array itself to work through our solution rather than use an additional
 * data structure.
 *
 * How it works
 * ------------
 * My initial solution was to use a data structure such as a set to store the integers found
 * in the array. Soon as we find a duplicate, we would return the value of the duplicate.
 * This would be O(n) T and O(n) S
 * However, the algoexpert.io solution obtains the same results with
 * O(n) T and O(1) S. So I will use this solution which works as follows:
 * For every number in the array, we determine the index by subracting 1 from it and the result
 * is the index of our number. We check if the number in that index is negative. If not, then we
 * make it negative and then move on in our iteration. If the number is negative, then we return
 * the value of the number we had found in our iteration.
 * */
public class FirstDuplicateValueImpl implements FirstDuplicateValue {
    @Override
    public int firstDuplicate(int[] array) {
        return 0;
    }
}
