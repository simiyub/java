package accounts;

import utils.Dao;

import java.util.Optional;

public class AccountStoreFactory {
    public static Dao dataStore(String hostName, int hostPort) {
        Optional<String> host =Optional.ofNullable(hostName);
        Optional<Integer> port = Optional.ofNullable(hostPort);

        return (host.isPresent() && port.isPresent()) ? new AccountDaoMongoImpl(host.get(),port.get()) : new AccountDaoCollectionImpl();
    }
}
