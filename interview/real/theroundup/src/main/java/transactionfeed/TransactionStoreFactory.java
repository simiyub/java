package transactionfeed;

import accounts.AccountDaoCollectionImpl;
import accounts.AccountDaoMongoImpl;
import utils.Dao;

import java.util.Optional;

public class TransactionStoreFactory {

    public static Dao dataStore(String hostName, int hostPort) {
        Optional<String> host =Optional.ofNullable(hostName);
        Optional<Integer> port = Optional.ofNullable(hostPort);

        return (host.isPresent() && port.isPresent()) ? new TransactionFeedDaoMongoImpl(host.get(),port.get()) : new TransactionFeedDaoCollectionImpl();
    }
}
