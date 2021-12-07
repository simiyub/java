package caesarcipherencryptor;

/**
 * Create an encryption function that creates a new string
 * obtained from shifting every letter in the original string by a given number of positions.
 * The function should allow us to wrap around the alphabet so that
 * when we get to the end of the alphabet, we continue from the beginning.
 * **/
public interface CaesarCipherEncryptor {
    String encrypt(String string, int shift);
}
