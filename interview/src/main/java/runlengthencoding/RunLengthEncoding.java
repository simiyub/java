package runlengthencoding;

/**
 * This function will receive a string and return a string that is encoded
 * using the run-length encoding:https://en.wikipedia.org/wiki/Run-length_encoding
 * We expect that the input string can contain special characters including numbers.
 * When a number exceeds 9, we use split encoding.
 * "AAAAAAAAAAA" will not be 11A because this could be interpreted as
 * 1 of 1 followed by an A.
 * Rather this will be encoded as 9A2A
 **/

public interface RunLengthEncoding {
    String encode(String string);
}
