package api;

import transactionfeed.FeedItem;
import utils.Dao;

/**
 * exposed to provide accounts for which transactions can be rounded
 * */
public class TransactionFeedApi {
    private static Dao<FeedItem>  store;

    public TransactionFeedApi(Dao store) {

        TransactionFeedApi.store =  store;
    }

    //TODO make this a real api
    public FeedItem[] transactionsEligibleForRounding(){
        return store.getAll();
    }
}
