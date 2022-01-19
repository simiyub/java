package generatedocument;

/**
 * This function takes two strings, one containing characters available to create a document
 * and the second is the document we actually want to create. The function then returns
 * true if we can create the document from the characters provided
 * or false if we cannot.
 * */
public interface GenerateDocument{
    boolean canGenerate(String charactersAvailable, String documentRequired);
}
