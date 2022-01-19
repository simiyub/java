package caesarcipherencryptor;

/**
 * O(n) T O(n) S as we iterate through the characters in the string to map them to their new value,
 * and return a new string.
 * How it works
 * ------------
 * We Use the unicode values of the alpha characters
 * to map to new character after shifting by the key provided.
 * */
public class CaesarCipherEncryptorImpl implements CaesarCipherEncryptor{

    @Override
    public String encrypt(String string, int shift) {
        char[] newArray = new char[string.length()];
        for (int i=0;i<=string.length()-1;i++){
            int newCode = string.charAt(i)+(shift%26);
            newArray[i]  = (newCode <= 122) ? (char)newCode : (char)(96+newCode%122);
        }
        return new String(newArray);
    }
}
