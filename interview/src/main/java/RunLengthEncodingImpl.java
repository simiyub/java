/**
 * O(n) T O(n) S as we iterate through the input array and encode the values as we do.
 * We implement the run length encoding by iterating through the string
 * encoding whenever the sequence of similar characters break.
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
