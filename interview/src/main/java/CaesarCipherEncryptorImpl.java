import java.util.HashMap;
import java.util.Map;

/***
 * Using a hashmap to store a mapping that can be used to generate the encrypted string.
 * */
public class CaesarCipherEncryptorImpl implements CaesarCipherEncryptor {

    private Map<Integer, Character> mapping (int cypherKey){
        Map<Integer, Character> map = new HashMap<>();
        char value = 'a';
        char key = 'a';
        for (int i=97+cypherKey;i<=122+cypherKey;i++){
            int index = i;
            if(i>122) index = i-122;
            map.put(index,value);
            value ++;
        }
        return map;
    }
    @Override
    public String encrypt(String string, int shift) {
        char[] newArray = new char[string.length()];
        for (int i=0;i<=string.length()-1;i++){
            int newCode = string.charAt(i)+shift;
            newArray[i]  = (newCode <= 122) ? (char)newCode : (char)(96+newCode%122);
        }
        return new String(newArray);
    }
}
