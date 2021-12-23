/**
 * This function takes two strings and returns the minimum number of edits required
 * for the first string to match the second string.
 * The edits include deletion, addition and substitution of characters.
 * */
public interface LevenshteinDistance {

    int levenshteinDistance(String string1,String string2);
}
