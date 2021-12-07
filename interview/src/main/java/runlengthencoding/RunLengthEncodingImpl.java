package runlengthencoding;

/**
 * O(n) T O(n) S
 * We encode the values as we iterate through the input array. We also take O(n)
 * to convert the characters in the array to a string, which is O(n) making 2 O(n). We drop the
 * constant and end up with O(n).
 * The space complexity is actually 2n as we add the int to encode the count of the characters.
 * However, as 2 is a constant, we are still left with n.
 *
 * We implement the run length encoding by iterating through the string
 * encoding whenever the sequence of similar characters exceeds 9, so we only use the integers 1-9 only once.
 * */
public class RunLengthEncodingImpl implements RunLengthEncoding {
    @Override
    public String encode(String string) {
        int count=0;
        StringBuilder arrayOfCharToReturn = new StringBuilder();
        int threshold = 9;
        char previousChar;
        for(int i=1;i<=string.length();i++){

            boolean found = false;
            previousChar = string.charAt(i-1);
            count ++;

            if(i != string.length() && string.charAt(i) == previousChar) found = true;

            if (count > threshold) {
                   arrayOfCharToReturn.append(threshold).append(previousChar);
                   count -= threshold;
               }

            if (!found && count>0) {
                arrayOfCharToReturn.append(count).append(previousChar);
                count =0;
            }
        }
        return arrayOfCharToReturn.toString();
    }
}
