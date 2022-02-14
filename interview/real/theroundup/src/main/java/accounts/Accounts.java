package accounts;

import java.util.Arrays;

public class Accounts {
    Account[] accounts;

    public Account[] getAccounts() {
        return accounts;
    }

    @Override
    public String toString() {
        return "Accounts{" +
                "entitledAccounts=" + Arrays.toString(accounts) +
                '}';
    }
}
