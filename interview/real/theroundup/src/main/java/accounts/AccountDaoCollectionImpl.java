package accounts;

import utils.Dao;

import java.util.*;

public class AccountDaoCollectionImpl implements Dao<Account> {
    private static Map<String, Account> store;

    AccountDaoCollectionImpl(){
        store =new HashMap<>();

    }

    @Override
    public Optional<Account> get(String id) {

        return Optional.of(store.get(id));
    }

    @Override
    public Account[] getAll() {
        return store.values().toArray(new Account[0]);
    }

    @Override
    public void save(Account account) {
        store.put(account.getName(), account);
    }
}
