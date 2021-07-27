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

        /**
         * Consider a string that can contain only characters from a-z.
         * Write a snippet of code that returns true if this string contains unique characters.
         * The whitespaces can be ignored.
         * */
    public boolean containsUniqueCharactersa_z(String string){
        Map<Character,Boolean> map = new HashMap<>();
        for (int i = 0; i < string.length(); i++) {
            if (string.codePointAt(i) >= 97  && string.codePointAt(i) <= 122) {
                char c = string.charAt(i);
                System.out.print(c);
                if (!Character.isWhitespace(c)) if (map.put(c, true) != null) return false;
            } else {
                throw new RuntimeException("Contains character with code value < 97 or >");
            }
        }

        return true;
    }

    /**
     * We can see the binary representation of a number using
     * Integer.toString(int i, int radix) or Integer.toBinaryString(int i).
     * Radix represents the base of the number representation.
     * */

    public String intToBinary(int number, int radix){
         String bin = Integer.toString(number,radix);
        System.out.println(bin);
        return bin;

    }

    /**
     * We can see the integer representation of a number using
     * Integer.parseInt(String i, int radix).
     * Radix represents the base of the number representation.
     * */
    public int binaryToInt(String bin, int radix) {
   return       Integer.parseInt(bin,radix);
    }

    public int bitwiseUnary(int i) {
        return ~5;
    }
}
