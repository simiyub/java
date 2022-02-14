package transactionfeed;

import accounts.Account;
import utils.Dao;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class TransactionFeedDaoCollectionImpl implements Dao<FeedItem> {
    private static Map<String, FeedItem> store;

    TransactionFeedDaoCollectionImpl(){
        store =new HashMap<>();

    }

    @Override
    public Optional<FeedItem> get(String id) {

        return Optional.of(store.get(id));
    }

    @Override
    public FeedItem[] getAll() {
        return store.values().toArray(new FeedItem[0]);
    }

    @Override
    public void save(FeedItem feedItem) {
        store.put(feedItem.feedItemUid, feedItem);
    }
}
