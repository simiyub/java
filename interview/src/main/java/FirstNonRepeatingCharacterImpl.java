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
        return 0;
    }
}
