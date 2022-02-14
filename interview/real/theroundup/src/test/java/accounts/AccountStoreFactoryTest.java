package accounts;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AccountStoreFactoryTest {

    @Test
    void returnsDataStore() {
        assertNotNull(AccountStoreFactory.dataStore(null,0));

    }
}