import accounts.*;
import api.AccountsApi;
import api.TransactionFeedApi;
import rounding.RoundingService;
import rounding.RoundingServiceImpl;
import transactionfeed.TransactionFeedService;
import transactionfeed.TransactionFeedServiceImpl;

public class RoundUpApp {
    public static void main(String[] args) {
        AccountService accountService = new AccountServiceImpl("test");
        accountService.getAccounts();

        AccountsApi accountsApi = accountService.accountsApi();
        System.out.println(accountsApi.accountsEligibleForRounding());

        TransactionFeedService transactionFeedService = new TransactionFeedServiceImpl("test");
        transactionFeedService.getTransactions(accountsApi.accountsEligibleForRounding());

        TransactionFeedApi transactionFeedApi = transactionFeedService.transactionFeedApi();
        System.out.println(transactionFeedApi.transactionsEligibleForRounding());

        RoundingService roundingService = new RoundingServiceImpl();
        roundingService.round(transactionFeedApi.transactionsEligibleForRounding());



    }
}
