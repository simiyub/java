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
                if (string.charAt(i) == string.charAt(i + 1)) {
                    int leftIndex = i;
                    int rightIndex = i+1;
                    int length = 2;

                    while (string.charAt(leftIndex) == string.charAt(rightIndex)){
                        leftIndex --;
                        rightIndex ++;
                    }
                    leftIndex++;
                    rightIndex--;
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
