package generatedocument;

import java.util.HashMap;
import java.util.Map;
/**
 *O(n+m) T O(uniqueChar) S We iterate through the two strings,
 * so the time complexity is the sum of the two.
 * We need space to store the map  of the characters
 * and count of how many there are in the characters available.
 *
 * How it works
 * ------------
 * We iterate through the characters available and store the count
 * Then we iterate through the document required
 * and each time check the store of characters available
 * reducing by 1 if we find it.
 * If we don't find the required character
 * or have run out of the characters from the map
 * then we return false
 * */
public class GenerateDocumentImpl implements GenerateDocument{
    @Override
    public boolean canGenerate(String charactersAvailable, String documentRequired) {
        Map<Character,Integer> charactersAvailableStore = new HashMap<>();
        for(int i=0; i<=charactersAvailable.length()-1;i++){
            char currentChar = charactersAvailable.charAt(i);
            int currentValue = charactersAvailableStore.getOrDefault(currentChar,-1);

            if(currentValue !=-1)charactersAvailableStore.replace(currentChar,currentValue+1);
            else charactersAvailableStore.put(currentChar,1);
        }
        for (int i=0;i<=documentRequired.length()-1;i++){
            char characterWanted = documentRequired.charAt(i);
            int currentValue = charactersAvailableStore.getOrDefault(characterWanted,-1);
            currentValue -=1;
            if(currentValue < 0) return false;
            else charactersAvailableStore.replace(characterWanted,currentValue);
        }
        return true;
    }
}
