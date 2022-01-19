import java.util.ArrayList;
import java.util.List;

/**
 * O(1) T O(1) S
 * We walk through the string as an array of characters and find the characters that
 * form valid IP Addresses and return them in an array of Strings.
 * How it works
 * ------------
 * We use a pointer to split the string into parts we have reviewed and those to be processed
 * When we find a substring of the string that is valid for each of the four parts we add
 * it to the valid ip address List and repeat until we have run through the whole string
 * and return the result.
 * TODO Simplify this
 * */
public class ValidIPAddressImpl implements ValidIPAddress {

    @Override
    public String[] validIPAddresses(String string){
        if (string.length()>12 || string.startsWith("0")) return new String[0];
        List<String> ipAddresses = new ArrayList<>();
        for(int i=1;i<Math.min(string.length(), 4);i++){

            String[] currentIPAddress = new String[]{"","","",""};
            String first = string.substring(0,i);
            if(isValid(first)){
                currentIPAddress[0] = first;

                for (int j=i+1;j<i+Math.min(string.length()-i,4);j++){
                String second= string.substring(i,j);
                if (isValid(second)) {
                    currentIPAddress[1] = second;

                    for (int k = j + 1; k < j + Math.min(string.length() - j, 4); k++) {
                        String third= string.substring(j, k);
                        String fourth = string.substring(k);

                        if (isValid(third) && isValid(fourth)) {
                            currentIPAddress[2] = third;
                            currentIPAddress[3] = fourth;
                            ipAddresses.add(arrayAsString(currentIPAddress));
                        }
                    }
                }
            }}


        }
        return ipAddresses.toArray(new String[0]);
    }

    private String arrayAsString(String[] array) {
        StringBuilder builder = new StringBuilder();
        for (int i=0;i< array.length;i++){
            builder.append(array[i]);
            if(i<array.length-1)builder.append(".");
        }
        return builder.toString();
    }

    private boolean isValid(String current) {
        int intValue = Integer.parseInt(current);
        boolean isValidInt = Integer.toString(intValue).equals(current);
        boolean isValidIPInt = intValue<=255;
        return isValidInt && isValidIPInt;
    }
}
