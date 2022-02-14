package transactionfeed;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.IOException;
import java.util.concurrent.CompletionException;

public class FeedItemObjectMapper extends com.fasterxml.jackson.databind.ObjectMapper {
    /**
     * Parses the given JSON string into a Map.
     */
   public FeedItems readValue(String content) {
        try {
            return this.readValue(content, new TypeReference<>() {
            });
        } catch (IOException ioe) {
            throw new CompletionException(ioe);
        }
    }
}
