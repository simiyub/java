package accounts;

import api.AccountsApi;

import java.util.Optional;

public interface AccountService {
    Optional<Accounts> entitledAccounts();

    void storeAccount(Account account);

    AccountsApi accountsApi();

    void getAccounts();
}
