package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Dao;

import static org.junit.jupiter.api.Assertions.*;

class AccountDaoCollectionImplTest {

    AccountDaoCollectionImpl accountStore;

    @BeforeEach
    void setUp() {
        accountStore = new AccountDaoCollectionImpl();
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