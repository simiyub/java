import java.util.Arrays;

/**
 * O(n) T and O(n) S as we will create an array of characters in the string to compare one pair at a time.
 * How it works
 * ------------
 * walk through the array with a pointer at the beginning and end of the array comparing characters
 * if we find any that are different, then we break from the check
 * */
public class PalindromeCheckImpl implements PalindromeCheck {
    @Override
    public boolean isPalindrome(String string) {
        char[] array = string.toCharArray();
        int end = array.length-1;
        for (int i=0; i<array.length-1;i++){
            if (array[i] != array[end]) return false;
            end --;
        }
        return true;
    }
}
