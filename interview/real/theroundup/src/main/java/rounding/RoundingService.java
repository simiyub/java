package rounding;

import transactionfeed.FeedItem;

public interface RoundingService {
    void round(FeedItem[] feedItems);
}
