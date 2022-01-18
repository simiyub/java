import java.util.List;

/**
 * This function will receive a string of length up to 12 characters and return all possible
 * valid IP addresses that can be created from it.
 * An IP address is considered valid if it is a sequence of four string parts delimited by a
 * period. Each of the parts has to be between 0 and 255 and cannot be a string with more than
 * one digit with a leading zero.
 * 192.168.0.01 is not valid while 192.168.0.0 is valid.
 * */
public interface ValidIPAddress {

    String[] validIPAddresses(String values);
}
