package transactionfeed;

import accounts.Account;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

public class TransactionFeedServiceTests {
    TransactionFeedService transactionFeedService;

    @BeforeEach
    void setUp() {
        transactionFeedService = new TransactionFeedServiceImpl("test");
    }


    @Test
    public void canHandleTransactions() {
        assertNotEquals(Optional.empty(),transactionFeedService.getEligibleTransactions(new Account()));
    }

    //TODO deside when to warn, ignore, notify or action exception.
    @Test
    public void canHandleNoTransactionsFound() {
        assertEquals(Optional.empty(), transactionFeedService.getEligibleTransactions(new Account()));
    }

    @Test
    public void canStoreTransactionsFound() {
        FeedItem item = new FeedItem();
        assertDoesNotThrow(() -> {
            transactionFeedService.storeTransaction(item);
        });
    }

}