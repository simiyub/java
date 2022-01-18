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
 * */
public class ValidIPAddressImpl implements ValidIPAddress {
    @Override
    public String[] validIPAddresses(String values) {
        List<String> ipAddresses = new ArrayList<>();
        //st
        return ipAddresses.toArray(new String[0]);
    }
}
