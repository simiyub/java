package accounts;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.ConfigProperties;

import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class AccountConfigTests {
    ConfigProperties configProperties;

    @BeforeEach
    void setUp() {
        configProperties = new ConfigProperties("account.properties");

    }

    @Test
    void hasAccountServiceConfig(){
        assertNotNull(configProperties.getProperty("TOKEN"));
        assertNotNull(configProperties.getProperty("REFRESH_TOKEN"));
        assertNotNull(configProperties.getProperty("ENDPOINT"));
    }
}
