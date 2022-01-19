package caesarcipherencryptor;

/**
 * This function will receive a string and an int representing a shift in a caesar cipher
 * then create a new string from shifting every letter in the original string by positions
 * equal to the shift provided. The function should allow us to wrap around the alphabet so that
 * when we get to the end of the alphabet, we continue from the beginning.
 * **/
public interface CaesarCipherEncryptor{
    String encrypt(String string, int shift);
}
