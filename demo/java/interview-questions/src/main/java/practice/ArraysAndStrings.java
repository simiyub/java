package practice;


import java.util.HashMap;
import java.util.Map;

public class ArraysAndStrings {

    /**
     * Consider a string that can contain ASCII and Unicode characters
     * ranging between 0-65,535.
     * Write a snippet of code that returns true if this string contains unique characters.
     * The whitespaces can be ignored.
     *
     * */
    public boolean containsUniqueCharactersASCIIAndUnicode(String string){
        Map<Character,Boolean> map = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                if (string.codePointAt(i) <= 65_535) {
                    char c = string.charAt(i);
                    System.out.print(c);
                    if (!Character.isWhitespace(c)) if (map.put(c, true) != null) return false;
                } else {
                    throw new RuntimeException("Contains unicode characters > 65,535");
                }
            }

            return true;
        }
}
