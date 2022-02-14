package transactionfeed;

import accounts.Account;
import api.TransactionFeedApi;

import java.util.Optional;

public interface TransactionFeedService {

    Optional<FeedItems> getEligibleTransactions(Account account);

    void storeTransaction(FeedItem feedItem);

    void getTransactions(Account[] accounts);

    TransactionFeedApi transactionFeedApi();
}
