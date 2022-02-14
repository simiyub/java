package transactionfeed;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Arrays;

@JsonIgnoreProperties(ignoreUnknown = true)
public class FeedItems {
    private FeedItem[] feedItems;

    public FeedItem[] getFeedItems() {
        return feedItems;
    }

    @Override
    public String toString() {
        return "FeedItems{" +
                "feedItems=" + Arrays.toString(feedItems) +
                '}';
    }
}
