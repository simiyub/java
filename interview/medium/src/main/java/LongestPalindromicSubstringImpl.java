/**
 * O(n) T O(n) S This implementation will run through the string once identifying the longest
 * palindrome and will store the characters in an array then return a string of those characters.
 *
 * How it works
 * ------------
 * We go through the array identifying every time we have identical
 * consecutive characters. When we do, we start walking in either direction
 * of the character within the array. When the corresponding characters do not  match
 * we break and check the length of the distance between the characters we've walked through.
 * If the length is greater than the longest distance we currently hold, then we have a new
 * long palindrome.
 * We stop once we have walked through the whole array and return the string between the
 * index we currently hold as longest.
 *
 * */
public class LongestPalindromicSubstringImpl implements LongestPalindromicSubstring{
    @Override
    public String longestPalindrome(String string) {
        if(string.length()>1) {
            int leftIndexLongest = 0;
            int rightIndexLongest = 0;
            for (int i = 0; i <= string.length()-2; i++) {
                boolean b = i>0 && string.charAt(i - 1) == string.charAt(i + 1);
                boolean b1 = string.charAt(i) == string.charAt(i + 1);
                if (b1 || b) {
                    int leftIndex = b ? i-1 : i;
                    int rightIndex = i+1;
                    boolean canExtend =true;

                    while (canExtend ){
                        if (leftIndex-1 >=0 && rightIndex+1<=string.length()-1 &&
                                string.charAt(leftIndex-1) == string.charAt(rightIndex+1)) {
                            canExtend = true;
                            leftIndex--;
                            rightIndex++;
                        }
                        else canExtend = false;
                    }

                    if((rightIndex-leftIndex)>(rightIndexLongest-leftIndexLongest)){
                     leftIndexLongest = leftIndex;
                     rightIndexLongest = rightIndex;
                    }
                }
            }
            char[] newPalindrome = new char[(rightIndexLongest - leftIndexLongest)+1];
            int index = leftIndexLongest;
            int newIndex = 0;
            for(int i=0;i<newPalindrome.length;i++){
                if(index<=rightIndexLongest){
                    newPalindrome[i] = string.charAt(index);
                    index ++;
                }
            }
            return new String(newPalindrome);
        }
        return string;
    }
}
