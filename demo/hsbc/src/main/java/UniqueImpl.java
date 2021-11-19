import java.util.HashMap;
import java.util.Map;

public class UniqueImpl implements Unique{
    public boolean isUnique(String string) {
        Map<Character, Boolean> map = new HashMap<>();
        for(int i=0; i<string.length();i++){
            if(map.put(string.charAt(i), true) != null){
                return false;
            }
        }
        return true;
    }
}
