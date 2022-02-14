package api;

import accounts.Account;
import accounts.AccountDaoCollectionImpl;
import accounts.AccountStoreFactory;
import utils.ConfigProperties;
import utils.Dao;

import java.io.InputStream;
import java.util.Properties;

/**
 * exposed to provide accounts for which transactions can be rounded
 * */
public class AccountsApi {
    private static Dao<Account>  store;

    public AccountsApi(Dao accountStore) {

        store =  accountStore;
    }

    //TODO make this a real api
    public Account[] accountsEligibleForRounding(){
        return store.getAll();
    }
}
