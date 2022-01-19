package firstnonrepeatingcharacter;

import java.util.HashMap;
import java.util.Map;

/**
 * O(n) T and O(1) S. We do two iterations making the time complexity 2 n,
 * and dropping the constant gives us O(n). We use the hashmap to store the character status
 *
 * How it works
 * ------------
 * We iterate through the characters in the string and use a map to store  a boolean
 * representation of whether we had seen the character before or not.
 * As we iterate through the characters, we check if it exists in the map as a key.
 * If it does, we flag as false meaning it is repeating as we've found another of the same character.
 * Once we get to the end of the string, we pick the first character in our string that has a true flag.
 * */
public class FirstNonRepeatingCharacterImpl implements FirstNonRepeatingCharacter {
    @Override
    public int firstNonRepeatingCharacterIndex(String string) {
        Map<Character,Boolean> characterUnique = new HashMap<>();
        for (int i=0;i<=string.length()-1;i++){
            char character = string.charAt(i);
            if(characterUnique.get(character) ==null) characterUnique.put(character, true );
            else characterUnique.put(character,false);
        }
        for(int i=0;i<=string.length()-1;i++) if (characterUnique.get(string.charAt(i))) return i;

        return -1;
    }
}
