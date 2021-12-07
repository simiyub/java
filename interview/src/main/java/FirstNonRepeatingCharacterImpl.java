import java.util.HashMap;
import java.util.Map;

/**
 * How it works
 * ------------
 * My first implementation uses a map to store character:boolean value mapping
 * of a character and whether it is unique or not.
 * We iterate through the string provided and check if it exists in the map as a key.
 * If it does, we flag as false meaning it is repeating as we've found another of the same character.
 * Once we get to the end of the string, we pick the first character in our string that has a true flag.
 * */
public class FirstNonRepeatingCharacterImpl implements FirstNonRepeatingCharacter {
    @Override
    public int firstNonRepeatingCharacterIndex(String string) {
        Map<Character,Boolean> characterUnique = new HashMap<>();
        for (int i=0;i<=string.length()-1;i++){
            char character = string.charAt(i);
            boolean present = characterUnique.getOrDefault(character,false);
            boolean unique = present ? false: true;
            characterUnique.put(character, unique );
        }
        for(int i=0;i<=string.length()-1;i++){
            if (characterUnique.get(string.charAt(i)) == true) return i;
        }
        return -1;
    }
}
