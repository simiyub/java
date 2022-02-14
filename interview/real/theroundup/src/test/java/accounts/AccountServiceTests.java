package accounts;

import accounts.Account;
import accounts.AccountService;
import accounts.AccountServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class AccountServiceTests {
    private AccountService accountService;

    @BeforeEach
    void setUp() {
        accountService = new AccountServiceImpl(null);
    }

    @Test
    public void canGetEntitledAccounts() {
        assertNotEquals(Optional.empty(),accountService.entitledAccounts());
    }

    //TODO Find a way to simulate no accountsFix this test
    @Test
    public void canHandleNoAccounts() {
        assertEquals(Optional.empty(), accountService.entitledAccounts());
            }

    //TODO improve this test:
    // needs to return something as proof it stored the account
            @Test
    public void canStoreAccounts(){
                Account account = new Account();
                String name = "Dummy";
                account.setName(name);
                assertDoesNotThrow(()->{
                    accountService.storeAccount(account);
                });

            }

}
