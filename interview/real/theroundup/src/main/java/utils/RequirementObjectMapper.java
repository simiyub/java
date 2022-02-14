package utils;

import accounts.Accounts;
import com.fasterxml.jackson.core.type.TypeReference;
import utils.Requirement;

import java.io.IOException;
import java.util.concurrent.CompletionException;

public class RequirementObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    /**
     * Parses the given JSON string into a Map.
     */
   public Requirement readValue(String content) {
        try {
            return this.readValue(content, new TypeReference<>() {
            });
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }
}
