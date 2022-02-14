package accounts;

import api.AccountsApi;
import utils.ConfigProperties;
import utils.Dao;

import java.util.Arrays;
import java.util.Optional;

public class AccountServiceImpl implements AccountService {
  private ConfigProperties configProperties;
  private Dao accountStore;
    private AccountsApi accountsApi;
    private final StarlingAcccounts starlingAcccounts = new StarlingAcccounts();

    public AccountServiceImpl(String env) {

        configProperties = new ConfigProperties("account.properties");

        //TODO review how we determine data store. This is not good.
        if (env=="Live"){
            accountStore = AccountStoreFactory.dataStore(
                    configProperties.getProperty("MONGO_DB_HOST"),
                    Integer.valueOf(configProperties.getProperty("MONGO_DB_PORT")));
        }
        else{
            accountStore = AccountStoreFactory.dataStore(null,0);
        }
        accountsApi=new AccountsApi(accountStore);

    }

    public void getAccounts(){
        entitledAccounts().ifPresent(acc->{
            Arrays.stream(acc.getAccounts()).forEach(ac ->{
                storeAccount(ac);

            });
        });
    }

    public Optional<Accounts> entitledAccounts() {
            return starlingAcccounts.entitledStarlingAccounts();

    }

    @Override
    public void storeAccount(Account account) {

        accountStore.save(account);
        System.out.println("stored:"+accountStore.get(account.getName()).orElse("None"));
    }

    @Override
    public AccountsApi accountsApi() {
        return accountsApi;
    }


}
