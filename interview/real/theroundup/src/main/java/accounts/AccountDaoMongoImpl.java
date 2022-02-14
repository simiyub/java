package accounts;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoDatabase;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.codecs.pojo.PojoCodecProvider;
import utils.ConfigProperties;
import utils.Dao;

import java.util.Optional;

import static com.mongodb.client.model.Filters.eq;
import static org.bson.codecs.configuration.CodecRegistries.fromProviders;
import static org.bson.codecs.configuration.CodecRegistries.fromRegistries;

public class AccountDaoMongoImpl implements Dao<Account> {
    private final MongoDatabase database;
    private final ConfigProperties configProperties;
    public AccountDaoMongoImpl(String host, int port) {
        configProperties = new ConfigProperties("account.properties");
        database = db(host, port);

    }

    private MongoDatabase db(String host, int port) {

       MongoClient mongoClient = new MongoClient(host, port);
        return mongoClient.getDatabase(configProperties.getProperty("MONGO_DB_ACCOUNTS_DB"))
                .withCodecRegistry(getCodecRegistry());

        //TODO change db to authenticated mode.

//        MongoClientSettings settings = MongoClientSettings.builder()
//                .codecRegistry(pojoCodecRegistry).build();
//        //       MongoClient mongoClient = MongoClients.create(settings);
////        MongoDatabase database = mongoClient.getDatabase("store");

    }

    private static CodecRegistry getCodecRegistry() {
        return fromRegistries(MongoClientSettings.getDefaultCodecRegistry(),
                    fromProviders(PojoCodecProvider.builder()
                            .automatic(true)
                            .build()));
    }

    @Override
    public Optional<Account> get(String id) {
        return Optional.empty();
    }

    @Override
    public Account[] getAll() {
        return new Account[0];
    }

    @Override
    public void save(Account account) {
        database.getCollection(configProperties.getProperty("MONGO_DB_ACCOUNTS_TABLE"),Account.class).insertOne(account);
    }
}
