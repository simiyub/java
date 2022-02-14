package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ConfigProperties;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoMongoImplTest {
    AccountDaoMongoImpl accountStore;
    ConfigProperties configProperties;

    @BeforeEach
    void setUp() {
        configProperties = new ConfigProperties("account.properties");
        accountStore = new AccountDaoMongoImpl(configProperties.getProperty("MONGO_DB_HOST"),
                Integer.valueOf(configProperties.getProperty("MONGO_DB_PORT")));
    }

    @Test
    void canGetAccount() {
        String name="dummy";
        Account account = new Account();
        account.setName(name);
        accountStore.save(account);
        assertEquals(account,accountStore.get(name).get());
    }

    @Test
    void canGetAllAccounts() {
        String name1="dummy";
        Account account1 = new Account();
        account1.setName(name1);
        accountStore.save(account1);

        String name2="dummy";
        Account account2 = new Account();
        account1.setName(name1);
        accountStore.save(account2);
        Account[] accounts = {account1,account2};
        assertArrayEquals(accounts,accountStore.getAll());
    }

    @Test
    void canSaveAccount() {
        String name="dummy";
        Account account = new Account();
        account.setName(name);
        assertDoesNotThrow( () ->{
            accountStore.save(account);
        });
    }
}