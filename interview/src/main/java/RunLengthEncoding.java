/**
 * The function encode should return a string
 * that has been encoded using the run-length encoding:https://en.wikipedia.org/wiki/Run-length_encoding
 * The input string can contain special characters including numbers. So split long runs should be split.
 **/

public interface RunLengthEncoding {
    String encode(String string);
}
