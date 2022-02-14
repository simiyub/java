package transactionfeed;

import accounts.Account;
import accounts.AccountStoreFactory;
import api.AccountsApi;
import api.TransactionFeedApi;
import utils.ConfigProperties;
import utils.Dao;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.time.temporal.ChronoUnit.DAYS;

public class TransactionFeedServiceImpl implements TransactionFeedService {
    private ConfigProperties configProperties;
    private TransactionFeedApi transactionFeedApi;

    public TransactionFeedServiceImpl(String environment) {
        Dao<FeedItem> transactionStore;
        configProperties = new ConfigProperties("transactionfeed.properties");
        if (environment=="Live"){
            transactionStore = TransactionStoreFactory.dataStore(
                    configProperties.getProperty("MONGO_DB_HOST"),
                    Integer.valueOf(configProperties.getProperty("MONGO_DB_PORT")));
        }
        else{
            transactionStore = TransactionStoreFactory.dataStore(null,0);
        }
        transactionFeedApi=new TransactionFeedApi(transactionStore);
    }


    @Override
    public Optional<FeedItems> getEligibleTransactions(Account account) {
        FeedItems feedItems = null;
        try{
        ConfigProperties configProperties = new ConfigProperties("transactionfeed.properties");
            FeedItemObjectMapper feedItemObjectMapper = new FeedItemObjectMapper();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(configProperties.getProperty("ENDPOINT")
                        +"account/"+account.getAccountUid()
                        +"/category/"+account.getDefaultCategory()
                +"?changesSince="+ Instant.now().minus(10,DAYS)))
                .setHeader("Authorization", "Bearer " + configProperties.getProperty("TOKEN"))
                .build();
             feedItems = HttpClient.newHttpClient().sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body)
              .thenApply(feedItemObjectMapper::readValue)
                .get();
            System.out.println(Arrays.toString(feedItems.getFeedItems()));
            System.out.println(feedItems.getFeedItems().length);

            Predicate<FeedItem> spendingItemsOnly = feedItem -> feedItem.getDirection().equals("OUT");
            Predicate<FeedItem> transactionCompleteOnly = feedItem -> feedItem.getStatus().equals("SETTLED");

             List<FeedItem> items = Arrays.stream(feedItems.getFeedItems())
                     .filter(spendingItemsOnly.and(transactionCompleteOnly))
                     .collect(Collectors.toList());
            System.out.println(items.size());
            System.out.println(items);


    } catch (Exception exception) {
        exception.printStackTrace();

    } finally {
        return Optional.ofNullable(feedItems);
    }
    }

    @Override
    public void storeTransaction(FeedItem feedItem) {

    }

    Consumer<FeedItems> store = feedItems ->
            Arrays.stream(feedItems.getFeedItems())
                    .forEach( item -> storeTransaction(item) );

    @Override
    public void getTransactions(Account[] accounts) {
        Arrays.stream(accounts)
                .forEach(account-> getEligibleTransactions(account)
                                .ifPresent( store));
    }

    public TransactionFeedApi transactionFeedApi() {
        return transactionFeedApi;
    }
}
